import java.util.*;

public class untilNumber_1 {
    private static int n;
    private static int k;

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        while(n > 0) {
            n /= k;
            answer += 1;
        }

        while(n != 1) {
            n -= 1;
            answer += 1;
        }


        System.out.println(answer);



    }
}