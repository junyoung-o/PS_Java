// 조건
// n을 x 로 나누었을때 나머지가 1
// 가장 작은 x

// 풀이
// n = Q * x + 1

class Solution {
    public int solution(int n) {
        int answer = 1;
        
        while(true) {
            if(n % answer == 1) {
                break;
            }
            answer += 1;
        }
        
        return answer;
    }
}