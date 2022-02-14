import java.util.*;

public class gameOfnumberCard {
    private static int answer;

    private static int n;
    private static int m;

    private static ArrayList<Integer>[] table;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        table = new ArrayList[n+1];

        for(int i = 0; i < n; i ++) {
            table[i] = new ArrayList();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j ++) {
                table[i].add(sc.nextInt());
            }
            Collections.sort(table[i]);
        }

        ArrayList<Integer> minList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                minList.add(table[i].get(0));
            }
        }

        Collections.sort(minList, Collections.reverseOrder());

        answer = minList.get(0);


        System.out.println(answer);



    }
}