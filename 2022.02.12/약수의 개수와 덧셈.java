// 조건
// left, right 사이 모든 수
// 약수가 짝수면 더하고
// 약수가 홀수면 뺀다.

// 입력
// left, right

// 풀이
// 1. 약수의 개수를 구한다.
// 2. 개수가 짝수면 더하고 홀수면 뺀다.

// 출력
// result


class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        if(left == right) {
            return left;
        }
        
        for(int i = left; i < right + 1; i++) {
            if(isEven(countDiv(i))) {
                answer += i;
            }
            else {
                answer -= i;
            }   
        }   
        
        return answer;
    }
    
    public boolean isEven(int a) {
        if(a % 2 == 0) {
            return true;
        }
        return false;
    }
    
    
    public int countDiv(int num) {
        if(num == 1) {
            return 1;
        }
        
        if(num == 2) {
            return 2;
        }
        
        int cnt = 0;
        boolean flag = false;
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                cnt += 1;
            }
            if( i * i == num) {
                flag = true;
            }
        }
        
        cnt *= 2;
        
        if(flag) {
            cnt -= 1;
        }
        System.out.println(num + " : " + cnt);
        
        
        
        return cnt;
    }
    
}