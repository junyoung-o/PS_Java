import java.util.*;

public class b_10162 {
    private static int A = 300;
    private static int B = 60;
    private static int C = 10;

    private static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        int answer = -1;

        if(T % A != 0 && T % B != 0 && T % C != 0) {
            answer = -1;
            System.out.println(answer);

        }

        else {
            // T = A * x + B * y + C * z
            // x, y, z 순으로 최대값 구하기

            int x = T / A;
            int y = T / B;
            int z = T / C;

            boolean flag = false;

            for(int i = x; i >= 0; i--) {
                if(flag) {
                    break;
                }
                
                for(int j = y; j >= 0; j--) {
                    if(flag) {
                        break;
                    }

                    for(int r = z; r >= 0; r--) {
                        if(A * i + B * j + C * r == T) {
                            System.out.println(i + " " + j + " " + r);
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
    }
}