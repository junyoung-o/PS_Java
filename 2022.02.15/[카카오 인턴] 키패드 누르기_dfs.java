import java.util.Scanner;

public class b_5585 {
    private static int coin = 1000;
    private static int[] coinList = {500, 100, 50, 10, 5, 1};;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        int payment = sc.nextInt();

        int remain = coin - payment;

        for(int c : coinList) {
            int cnt = remain / c;
            answer += cnt;
            remain -= c * cnt;
        }    

        System.out.println(answer);
    }
}