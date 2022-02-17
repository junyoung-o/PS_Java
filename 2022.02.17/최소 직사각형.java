// 조건
// 1. 가로 세로 돌렸을 때 둘 중 한번은 들어가야 한다.
// 2. 모두 수납할 수 있는 가장 작은 지갑

// 풀이
// 현재 카드가 들어 갈 수 있는지 확인
// 들어 갈 수 없다면 갱신

// 갱신
// 둘 중 하나만 안들어 갈때
// min(row, col) = max(x, y)

// 둘 다 안들어 갈때
// row = x, col = y

class Solution {
    int row = 0;
    int col = 0;
    
    public int solution(int[][] sizes) {
        int answer = 0;
        
        for(int[] s : sizes) {
            int x = s[0];
            int y = s[1];
            
            if(!(isAval(Math.max(x, y), Math.min(x, y)))) {
                updateWalet(Math.max(x, y), Math.min(x, y));
            }
            // System.out.println(row + ", " + col);
        }
        
        answer = row * col;
        
        return answer;
    }
    
    public boolean isAval(int a, int b) {
        if(row >= a && col >= b) {
            return true;
        }
        return false;
    }
    
    public void updateWalet(int a, int b) {
        if((row < a && col < b)) {
            row = a;
            col = b;
        }
        
        else {
            if(Math.max(row, col) < Math.max(a, b)) {
                row = Math.max(a, b);
            }
            
            if(Math.min(row, col) < Math.min(a, b)) {
                col = Math.min(a, b);
            }
        }
    }
    
}