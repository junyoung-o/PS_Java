import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
    
        long cnt = (count * (count + 1)) / 2;
        answer = Math.max(price * cnt - money, 0);
        
        return answer;
    }
}