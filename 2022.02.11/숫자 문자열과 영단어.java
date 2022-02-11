import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        HashMap<String, String> dict = new HashMap<>();
        dict.put("zero", "0");
        dict.put("one", "1");
        dict.put("two", "2");
        dict.put("three", "3");
        dict.put("four", "4");
        dict.put("five", "5");
        dict.put("six", "6");
        dict.put("seven", "7");
        dict.put("eight", "8");
        dict.put("nine", "9");
        
        StringBuilder target = new StringBuilder();
        String tmp = s;
        for(int i = 0; i < s.length(); i ++) {
            char alpha = s.charAt(i);
            
            if(('a' <= alpha && alpha <= 'z') || ('A' <= alpha && alpha <= 'Z')) {
                target.append(s.charAt(i));
                
            }
            
            if(dict.get(target.toString()) != null) {
                tmp = tmp.replace(target.toString(), dict.get(target.toString()));
                target.setLength(0);
            }
        }
        
        answer = Integer.parseInt(tmp);
        
        return answer;
    }
}