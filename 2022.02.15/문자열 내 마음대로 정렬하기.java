// 조건
// 1. n번째 인덱스 순으로 정렬
// 2. 만약 같다면 문자열 순으로 정렬


import java.util.*;
import java.util.Map.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        HashMap<String, String> stringMap = new HashMap<>();
        
        for(String s : strings) {
            stringMap.put(s, Character.toString(s.charAt(n)));
        }
        
        List<Entry<String, String>> list_entries = new ArrayList<Entry<String, String>>(stringMap.entrySet());
        Collections.sort(list_entries, (s1, s2)->s1.getKey().compareTo(s2.getKey()));
        Collections.sort(list_entries, (s1, s2)->s1.getValue().compareTo(s2.getValue()));
        
        // System.out.println(list_entries.toString());
        
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : list_entries) {
            result.add(entry.getKey());
        }
        
        answer = result.toArray(new String[result.size()]);

        // System.out.println();
        return answer;
    }
}