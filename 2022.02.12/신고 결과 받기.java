// 조건
// 신고 횟수 제한 없음
// 서로 다른 유저를 신고 할 수 있음 (같은 유저 중복 x)
// k번 이상 신고된 유저는 정지
// 신고한 유저들에게 정지 메일 발송


// 입력
// 유저 list, A가 B를 신고, k

// 풀이 
// 1. 1번 데이터를 만들고 정지된 유저에게 3번 데이터로 메일 보냄
// 2. 2번 데이터를 만들고 정지 유저를 신고한 ID 3번 데이터로 메일 보냄

// 필요한 data
// 1. 신고당한 유저 ID, 신고 받은 횟수
// 2. 신고당한 유저 ID : {신고한 유저들}
// 3. 유저별 메일 받은 횟수 저장 data

// 출력
// 메일 받은 횟수
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        
        // data3
        HashMap<String, Integer> data3 = new HashMap<>();
        
        for(String user : id_list) {
            data3.put(user, 0);
        }
        
        //data1, 2
        HashMap<String, Integer> data1 = new HashMap<>();
        HashMap<String, ArrayList<String>> data2 = new HashMap<>();
        for(String r : report) {
            String[] userReport = r.split(" ");
            // System.out.println(userReport[0] + " " + userReport[1]);
            
            if(!data1.containsKey(userReport[1])) {
                data1.put(userReport[1], 1);
                data2.put(userReport[1], new ArrayList());
                data2.get(userReport[1]).add(userReport[0]);
            }
            
            else if(!data2.get(userReport[1]).contains(userReport[0])) {
                int temp = data1.get(userReport[1]) + 1;
                data1.put(userReport[1], temp);
                data2.get(userReport[1]).add(userReport[0]);
            }
        }
        
        // 풀이 1, 2
        Iterator<String> iter = data1.keySet().iterator();
        while(iter.hasNext()) {
            String user = iter.next();
            int r = data1.get(user);
            if(r >= k) {
                // **** 1풀이 1번 해석 오류
                // 신고 받은 유저는 메일 받지 않는다..
                // int temp = data3.get(user) + 1;
                // data3.put(user, temp);
                
                ArrayList<String> users = data2.get(user);
                Iterator<String> iter2 = users.iterator();
                while(iter2.hasNext()) {
                    String user2 = iter2.next();
                    int temp2 = data3.get(user2) + 1;
                    data3.put(user2, temp2);
                }
                
            }
            
        }
        
        // 출력 맞추기
        Iterator<String> iter3 = data3.keySet().iterator();
        while(iter3.hasNext()) {
            String result_user = iter3.next();            
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        int ind = 0;
        for(String user : id_list) {
            result.add(data3.get(user));
            // System.out.println(user + " : " + data3.get(user));
            answer[ind++] = data3.get(user);
        }
        
        return answer;
    }
}