// 조건
// 1. N 개의 카드가 있다.
// 2. M 숫자를 몇개 가지고?

import java.util.*;

public class b_10816 {
    private static int n;
    private static int m;
    
    private static HashMap<Integer, Integer> cardList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cardList = new HashMap<>();

        n = Integer.parseInt(br.readLine());
        String[] x = br.readLine().split(" ");

        for(String y : x) {
            int t = Integer.parseInt(y);
            cardList.put(t, cardList.getOrDefault(t, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        m = Integer.parseInt(br.readLine());
        x = br.readLine().split(" ");
        for(String y : x) {
            int t = Integer.parseInt(y);
            sb.append(cardList.getOrDefault(t, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}