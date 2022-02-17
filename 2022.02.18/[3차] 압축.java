// 조건
// 1. 길이가 1인 모든 단어 포함하여 사전 초기화
// 2. 가장 긴 문자열 w를 찾는다.
// 3. w로 사전 초기화
// 4. 남는 글자 있다면 (w+c) 사전에 등록
// 5. 등록

// 풀이
// 1. 길이가 1인 단어 등록해서 초기화


// 2. 등록되어 있는 가장 긴 글자 찾기
// 3. 출력하고 다음 글자 등록

import java.util.*;

class Solution {
    int currentPointer = 0;
    int nextIndex = 1;
    HashMap<String, Integer> dict;
    
    
    public int[] solution(String msg) {
        int[] answer = {};
        
        
        ArrayList<Integer> result = new ArrayList<>();
        dict = new HashMap<>();
        
        for(char i = 'A'; i <= 'Z'; i++) {
            dict.put(Character.toString(i), nextIndex);
            nextIndex += 1;
        }
        
        while(currentPointer < msg.length()) {
            StringBuffer sb = new StringBuffer();
            sb.append(findLongW(msg));
            
            String x = sb.toString();
            result.add(dict.get(x));
            
            updateDict(x, msg);
            checkPoint = x;            
        }
        
        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
    
    public String findLongW(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toString(msg.charAt(currentPointer)));

        boolean endOfStr = false;
        while(dict.containsKey(sb.toString())) {            
            if(currentPointer >= msg.length() - 1) {
                endOfStr = true;
                currentPointer += 1;
                break;
            }
            
            currentPointer += 1;
            sb.append(Character.toString(msg.charAt(currentPointer)));
        }
        
        if(!endOfStr) {
            String longestStr = sb.toString();
            longestStr = longestStr.substring(0, longestStr.length() - 1);
            return longestStr;
        }
        else {
            String longestStr = sb.toString();
            return longestStr;
        }
        
    }
    
    public void updateDict(String x, String msg) {
        StringBuffer sb = new StringBuffer();
        sb.append(x);
        
        if(currentPointer < msg.length()) {
            sb.append(Character.toString(msg.charAt(currentPointer)));
        }
        dict.put(sb.toString(), nextIndex);
        nextIndex += 1;
    }
    
}