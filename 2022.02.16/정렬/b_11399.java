import java.util.*;
import java.io.*;
import java.text.ParsePosition;

public class b_11399 {
    private static int n;
    private static ArrayList<Integer> P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        P = new ArrayList<>();
        String[] PIn = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            P.add(Integer.parseInt(PIn[i]));
        }

        Collections.sort(P);

        int answer = 0;
        for(int i = 0; i < n; i++) {
            int cnt = n - i;
            answer += P.get(i) * cnt;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}