// 조건
// 1. 00시00분00초 부터 N시 59분 59초 까지 3이 포함되는 모든 경우의 수

import java.util.*;

class Solution {
    private static int n;

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        
        int baseCnt = 0;
        for(int h = 0; h < n+1; h ++) {
            for(int m = 0; m < 60; m++) {
                for(int s = 0; s < 60; s++) {
                    String x = Integer.toString(h);
                    String y = Integer.toString(m);
                    String z = Integer.toString(s);
    
                    String target = x.concat(y);
                    target = target.concat(z);
    
                    if(target.contains("3")) {
                        baseCnt += 1;
                    }
                }
            }
        }

        System.out.println(baseCnt);


    }
}