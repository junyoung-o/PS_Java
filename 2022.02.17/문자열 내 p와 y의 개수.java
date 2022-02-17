import java.util.*;
import java.util.regex.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        String str_ = s.toLowerCase();
        
        Pattern p = Pattern.compile("[p]{1}");
        Matcher m = p.matcher(str_);
        
        int pCnt = 0;
        while(m.find())
            pCnt += 1;
        
        Pattern y = Pattern.compile("y");
        m = y.matcher(str_);
        
        int yCnt = 0;
        while(m.find())
            yCnt += 1;
        
        if(pCnt == yCnt) {
            answer = true;
        }        
        
        return answer;
    }
}