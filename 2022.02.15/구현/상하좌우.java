// 조건
// 1. 상 하 좌 우 이동
// 2. 공간 벗어나면 무시
// 3. RUDL로 이동

import java.util.*;

class Solution {
    private static int[] pos = {1, 1};
    private static int n;

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        String[] move = sc.nextLine().split(" ");

        for(String m : move) {
            if(m.equals("R")) {
                if(pos[1] < n) {
                    pos[1] = pos[1] + 1;
                }
            }
            else if(m.equals("L")) {
                if(pos[1] > 1) {
                    pos[1] -= 1;
                }
            }
            else if(m.equals("U")) {
                if(pos[0] > 1) {
                    pos[0] -= 1;
                }
            }
            else if(m.equals("D")) {
                if(pos[0] < n) {
                    pos[0] += 1;
                }
            }
        }

        System.out.println(pos[0] + " " + pos[1]);



    }
}