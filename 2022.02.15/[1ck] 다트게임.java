// 조건
// 1. S, D, T : 제곱
// 2. * : (바로 전 점수 + 해당 점수) * 2
// 2-1. 맨 처음 * 일 경우 : 첫 점수 * 2
// 2-2. * 중첩 가능 : 2번이면 4배
// 3. # : -(해당 점수)
// 3-1. * 와 중첩

import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        ArrayList<Integer> list_ = new ArrayList<Integer>();
        
        String bonus = "[\\d]+[SDT][*#]*";
        
        Pattern compiler = Pattern.compile(bonus);
        Matcher x = compiler.matcher(dartResult);
        
        int index = 0;
        while(x.find()) {
            String str = x.group();
            // System.out.println(str);
            
            if(str.endsWith("S")) {
                int tmp = Integer.parseInt(str.substring(0, str.indexOf("S")));
                list_.add(tmp);
            }
            else if(str.endsWith("D")) {
                int tmp = Integer.parseInt(str.substring(0, str.indexOf("D")));
                list_.add((int)Math.pow(tmp, 2));
            }
            else if(str.endsWith("T")) {
                int tmp = Integer.parseInt(str.substring(0, str.indexOf("T")));
                list_.add((int)Math.pow(tmp, 3));
            }
            
            else if(str.endsWith("*")) {
                int t = 0;
                for(int i = str.length() - 1; i >= 0; i--) {
                    if(str.charAt(i) == '*') {
                        t += 1;
                    }
                    else {
                        break;
                    }
                }
                if(str.charAt(str.length() - 1 - t) == 'S') {
                    int tmp = Integer.parseInt(str.substring(0, str.indexOf("S")));
                    list_.add(tmp * (int)Math.pow(2, t));
                }
                else if(str.charAt(str.length() - 1 - t) == 'D') {
                    int tmp = Integer.parseInt(str.substring(0, str.indexOf("D")));
                    list_.add((int)Math.pow(tmp, 2) * (int)Math.pow(2, t));
                }
                else if(str.charAt(str.length() - 1 - t) == 'T') {
                    int tmp = Integer.parseInt(str.substring(0, str.indexOf("T")));
                    list_.add((int)Math.pow(tmp, 3) * (int)Math.pow(2, t));
                }
                
                // list_.set(list_.get(index - 1) * (int)Math.pow(2, t));
                if(index != 0) {
                    int v = list_.get(index - 1);
                    list_.set(index - 1, list_.get(index - 1) * (int)Math.pow(2, t));
                }
            }
            else if(str.endsWith("#")) {
                String kk = str.substring(0, str.length()-1);
                if(kk.endsWith("S")) {
                    int tmp = Integer.parseInt(str.substring(0, str.indexOf("S")));
                    list_.add(tmp * -1);
                }
                else if(kk.endsWith("D")) {
                    int tmp = Integer.parseInt(str.substring(0, str.indexOf("D")));
                    list_.add((int)Math.pow(tmp, 2) * -1);
                }
                else if(kk.endsWith("T")) {
                    int tmp = Integer.parseInt(str.substring(0, str.indexOf("T")));
                    list_.add((int)Math.pow(tmp, 3) * -1);
                }
            }
            
            index += 1;
            
        }
        
        // System.out.println(list_);
        Iterator<Integer> iter = list_.iterator();
        while(iter.hasNext()) {
            int c = iter.next();
            answer += c;
        }
        
        return answer;
    }
}