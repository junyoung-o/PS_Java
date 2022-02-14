import java.util.*;

public class principleOfBigNumber {
    private static int n;
    private static int m;
    private static int k;

    private static int answer = 0;

    private static ArrayList<Integer> numList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i ++) {
            numList.add(sc.nextInt());
        }

        Collections.sort(numList, Collections.reverseOrder());
        int firstNumber = numList.get(0);
        int secondNumber = numList.get(1);

        int cursive = m / (k + 1);
        int cursiveRemain = m % (k + 1);

        int answer = cursive * (firstNumber * k + secondNumber) + cursiveRemain * firstNumber;

        System.out.println(answer);



    }
}