class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = step1(new_id);
        answer = step2(answer);
        answer = step3(answer);
        answer = step4(answer);
        answer = step5(answer);
        answer = step6(answer);
        answer = step7(answer);
        
        return answer;
    }
    
    public String step1(String str) {
        return str.toLowerCase();
    }
    
    public String step2(String str) {
        String re = "[^\\w\\-_.]*";
        return str.replaceAll(re, "");
    }
    
    public String step3(String str) {
        String re = "[.]+";
        return str.replaceAll(re, ".");
    }
    
    public String step4(String str) {
        if(str.startsWith(".")) {
            str = str.substring(1);
        }
        if(str.endsWith(".")) {
            str = str.substring(0, (int) str.length() - 1);
        }
        return str;
    }
    
    public String step5(String str) {
        if(str.isEmpty()) {
            str = str.concat("a");
        }
        return str;
    }
    
    public String step6(String str) {
        if(16 <= str.length()) {
            str = str.substring(0, 15);
        }
        if(str.endsWith(".")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
    
    public String step7(String str) {
        if(str.length() <= 2) {
            String target = str.substring(str.length() - 1, str.length());
            while(str.length() != 3) {
                str = str.concat(target);
            }
        }
        return str;
    }
    
}