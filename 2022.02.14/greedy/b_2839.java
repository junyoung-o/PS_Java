// 조건
// 1. 최대한 적은 봉지
// 2. 정확하게 N 킬로그램
// 3. 3, 5 킬로그램
// 4. 정확하게 N 킬로그램 못 만들면 -1

// 고려
// 1. 최대한 5로 채우려고 한다.
// 2. 하지만 5로 최대한 채우다가 3으로 안나눠 떨어질 수도 있다.

// 풀이
// 1. n = 5 * x + 3 * y 인지 확인
// 2. 안나눠 떨어지면 무조건 -1
// 3. 나눠 떨어지면 x를 최대, y를 최소

import java.util.*;

public class b_2839 {
    private static int n;

    private static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int x = n / 5;
        int y = n / 3;

        for(int i = 0; i <= y; i++) {
            if(answer != -1) {
                break;
            }

            for(int j = x; j >=0; j--) {
                if(n == (j * 5) + (i * 3)) {
                    answer = i + j;
                    break;
                }

            }
        }
        

        
        

        System.out.println(answer);



    }
}