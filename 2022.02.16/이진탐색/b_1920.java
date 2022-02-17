import java.util.*;
import java.io.*;

public class b_1920 {
    private static int n;
    private static int m;

    private static ArrayList<Integer> A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.parseInt(br.readLine());
        A = new ArrayList<>();

        String[] aIn = br.readLine().split(" ");
        for(String a : aIn) {
            A.add(Integer.parseInt(a));
        }
        
        Collections.sort(A);
        
        m = Integer.parseInt(br.readLine());
        String[] mIn = br.readLine().split(" ");
        for(String mm : mIn) {
            int target = Integer.parseInt(mm);

            if(searching(0, n, target)) {
                bw.write("1\n");
                bw.flush();
            }

            else {
                bw.write("0\n");
                bw.flush();
            }
        }
    }

    public static boolean searching(int start, int end, int target) {
        if(start >= end) {
            return false;
        }

        if(start == end - 1) {
            if(A.get(start) == target) {
                return true;
            }
            return false;
        }
        
        int middle = (start + end) / 2;

        if(target < A.get(middle)) {
            return searching(start, middle, target);
        }

        else if(target > A.get(middle)) {
            return searching(middle, end, target);
        }

        else {
            return true;
        }
    }
}