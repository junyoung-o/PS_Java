class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {1, 6};
        
        // 현재 로또 당첨 갯수
        int current_score = get_current_score(lottos, win_nums);
        
        int min_score = current_score;
        int max_score = current_score + count_zero(lottos);
        
        if(min_score == 0) {
            answer[1] = 6;
        }else {
            answer[1] = 6 - min_score + 1;                
        }
        
        if(max_score == 0) {
            answer[0] = 6;
        }else {
            answer[0] = 6 - max_score + 1;
        }
        
        return answer;
    }
    
    public int get_current_score(int[] lottos, int[] win_nums) {
        int cnt = 0;
        
        for(int i = 0; i < lottos.length; i++) {
            int number = lottos[i];
            
            for(int j = 0; j < win_nums.length; j++) {
                int target = win_nums[j];
                
                if(number == target) {
                    cnt += 1;
                    break;
                }
            }
        }
        
        return cnt;
    }
    
    public int count_zero(int[] lottos) {
        int cnt = 0;
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                cnt += 1;
            }
        }
        
        return cnt;
    }
    
    
    
    
    
    
    
}