// 조건
// 1. N 개의 카드가 있다.
// 2. M 숫자를 몇개 가지고?

import java.util.*;
import java.io.*;

public class b_10816 {
    private static int n;
    private static int m;
    
    private static int[] countsort;

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String[] x = br.readLine().split(" ");
        
        countsort = new int [20000001];
        for(String y : x) {
            int t = Integer.parseInt(y);
            countsort[t + 10000000] += 1;
        }
        
        m = Integer.parseInt(br.readLine());
        x = br.readLine().split(" ");
        
        for(String y : x) {
            int t = Integer.parseInt(y);
            bw.write(countsort[t + 10000000]+ " ");
            bw.flush();
        }

    }
}