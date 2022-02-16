// 조건
// 1. N 개의 카드가 있다.
// 2. M 숫자를 몇개 가지고?

import java.util.*;

public class b_10816 {
    private static int n;
    private static int m;
    
    private static HashMap<Integer, Integer> cardList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        cardList = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(cardList.keySet().contains(x)) {
                cardList.replace(x, cardList.get(x) + 1);
            }
            else{
                cardList.put(x, 1);
            }
        }
        
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            
            if(cardList.keySet().contains(x)) {
                System.out.print(cardList.get(x) + " ");

            }
            else {
                System.out.print(0 + " ");
            }
        }
    }
}