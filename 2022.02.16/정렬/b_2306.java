import java.util.*;

public class b_2306 {
    private static ArrayList<Integer> list_;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int sum = 0;
        list_ = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            int x = sc.nextInt();
            list_.add(x);
            sum += x;
        }

        for(int i = 0; i < list_.size(); i++) {
            for(int j = i+1; j < list_.size(); j ++) {
                if(sum - (list_.get(i) + list_.get(j)) == 100) {
                    list_.remove(i);
                    list_.remove(j-1);
                    break;
                }
            }
        }

        Collections.sort(list_);


        for(int x : list_) {
            System.out.println(x);
        }

    }
}