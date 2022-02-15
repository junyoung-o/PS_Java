// 조건
// 1. 수평 2칸, 수직 1칸
// 2. 수평 1칸, 수직 2칸
// 3. table은 8 x 8

import java.util.*;

class Solution {
    private static int[] row = {1, 1, -1, -1, 2, 2, -2, -2};
    private static int[] col = {2, -2, 2, -2, 1, -1, 1, -1};
    
    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        String loc = sc.nextLine();

        int cLoc = (loc.charAt(0) - 'a') + 1;
        int rLoc = (loc.charAt(1) - '1') + 1;

        for(int i = 0; i < 8; i++) {
            answer += 1;

            int mRow = row[i];
            int mCol = col[i];

            int currentRow = mRow + rLoc;
            int currentCol = mCol + cLoc;

            if(currentRow < 1 || currentCol < 1 || currentRow > 8 || currentCol > 8) {
                answer -= 1;
            }

        }
        System.out.println(answer);

    }

}