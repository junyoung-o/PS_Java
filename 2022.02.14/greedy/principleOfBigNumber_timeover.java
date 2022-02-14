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
        

        while(m != 0) {
            for(int i = 0; i < k; i++, m--) {
                if(m == 0) {
                    break;
                }
                answer += numList.get(0);
            }

            if(m == 0) {
                break;
            }
            answer += numList.get(1);
            m -= 1;
        }


        System.out.println(answer);



    }
}