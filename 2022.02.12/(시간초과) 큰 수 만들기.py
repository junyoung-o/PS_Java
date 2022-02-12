def recur(number, currentNumber, resultLen, pointer):
    global result
    
    # print(number, currentNumber, resultLen, pointer)
    if(len(currentNumber) == resultLen):
        result = max(result, int(currentNumber))
        return
    
    if(pointer >= len(number)):
        return
    
    
    ## 선택
    recur(number, currentNumber + number[pointer], resultLen, pointer + 1)
    
    ## 선택 x
    recur(number, currentNumber, resultLen, pointer + 1)
    
result = 0    
def solution(number, k):
    answer = "0"
    
    resultLen = len(number) - k
    
    recur(number, "", resultLen, 0)
    
    answer = str(result)
    return answer