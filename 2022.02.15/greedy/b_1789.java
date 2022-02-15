import java.util.*;

class b_1789 {
    private static long S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextLong();

        int t = 1;
        int answer = 0;
        while(S != 0) {
            if(S - t >= 0) {
                S -= t;
                answer += 1;
                t++;
            }

            if(t > S) {
                break;
            }
        }

        System.out.println(answer);




        
    }
}