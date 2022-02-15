// 조건
// 1. 0, 1, 2, 3 : 북 동 남 서
// 2. 현재 방향에서 왼쪽으로 돈다. (북 서 남 동) -> (0 3 2 1) -> (pos + 3 % 4)
// 3. 가보지 않은 칸이 있다면 돈다.
// 4. 가보지 않은 칸이 없다면 회전한 채로 1칸 뒤로 가서 1단계
// 5. 사방 모두 갈 수 없다면 종료




import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

class Solution {
    private static int currentPos;
    private static int[] currentLoc = {-1, -1};

    private static int[][] gameMap;

    private static boolean[] visit;
    
    private static int n;
    private static int m;

    private static int[] toMove = {-1, 1, 1, -1};



    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visit = new boolean[n * m + 1];
        for(int i = 0; i < n * m + 1; i++) {
            visit[i] = false;
        }

        currentLoc[0] = sc.nextInt();
        currentLoc[1] = sc.nextInt();

        currentPos = sc.nextInt();
        sc.nextLine();

        gameMap = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int x = sc.nextInt();
                gameMap[i][j] = x;
            }
        }



        int result = moving(0, 0, false);





        System.out.println(result + 1);

    }

    public static int moving(int answer, int rotateCnt, boolean flag) {
        currentPos = rotatePos();
        int dx = currentLoc[1];
        int dy = currentLoc[0];

        visit[getNodeNumber(dy, dx)] = true;
        // rotate 횟수가 4이고 4번 다 움직이지 못했다면
        if(rotateCnt >= 4 && !flag) {
            return answer;
        }
        // System.out.println(currentPos + " : (" + currentLoc[0] + ", " + currentLoc[1] + ") : " + rotateCnt + ", " + flag);

        if((currentPos == 1 || currentPos == 3)) {
            dx += toMove[currentPos];
        }
        
        if((currentPos == 0 || currentPos == 2)) {
            dy += toMove[currentPos];
        }
        // System.out.println(currentLoc[0] + ", " + currentLoc[1] + " -> " + dy + ", " + dx);
        // System.out.println("condition : " + gameMap[dy][dx] + ", " + visit[getNodeNumber(dy, dx)]);

        // 움직일 수 있다면 움직이기
        if(!(dx < 0 || dx >= m || dy < 0 || dy >= n || gameMap[dy][dx] == 1 || visit[getNodeNumber(dy, dx)]) && (dx != currentLoc[1] || dy != currentLoc[0])) {
            System.out.println(currentLoc[0] + ", " + currentLoc[1] + " -> " + dy + ", " + dx);

            currentLoc[1] = dx;
            currentLoc[0] = dy;
            flag = true;
            rotateCnt = 0;
            answer += 1;

        }
        else {
            rotateCnt += 1;
            flag = false;
        }

        int result = moving(answer, rotateCnt, flag);
        return result;
    }

    public static int getNodeNumber(int x, int y) {
        return (m * x) + y;
    }

    public static int rotatePos() {
        return (currentPos + 3) % 4;
    }

}