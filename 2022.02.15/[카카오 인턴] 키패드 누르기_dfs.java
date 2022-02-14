// 조건
// 왼손은 * 부터 오른손은 # 부터
// 손가락은 상하좌우 4 방향
// 1, 4, 7은 왼손
// 3, 6, 9는 오른손
// 2, 5, 8, 0은 가까운 손가락 (같다면 손잡이)

// 왼손 위치, 오른손 위치 저장
// 거리 구하기

import java.util.*;

class Solution {
    private static String leftPoint = "10";
    private static String rightPoint = "11";
    
    private static String mostLeft = "147";
    private static String mostRight = "369";
    private static String middle = "2580";
    
    private static ArrayList<Integer>[] table;
    private static boolean[] visit;
    
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        visit = new boolean[11 + 1];
        for(int i = 0; i < 12;i++) {
            visit[i] = false;
        }
        
        
        table = new ArrayList[11 + 1];
        for(int i = 0; i < 12; i++) {
            table[i] = new ArrayList();
        }
        
        table[1].add(2);
        table[4].add(5);
        table[7].add(8);
        table[10].add(0);
        
        table[2].add(5);
        table[5].add(2);
        table[5].add(8);
        table[8].add(5);
        table[0].add(8);
        table[8].add(0);
        
        table[3].add(2);
        table[6].add(5);
        table[9].add(8);
        table[11].add(0);
        
        for(int i = 0; i < 12; i++) {
            Collections.sort(table[i]);
        }
        
        for(int num : numbers) {
            String n = Integer.toString(num);
            if(mostLeft.contains(n)) {
                answer.append("L");
                leftPoint = n;
            }
            else if(mostRight.contains(n)) {
                answer.append("R");
                rightPoint = n;
            }
            else {
                for(int i = 0; i < 12;i++) {
                    visit[i] = false;
                }
                
                int leftDistance = getDistance(n, "l");
                
                for(int i = 0; i < 12;i++) {
                    visit[i] = false;
                }
                
                int RightDistance = getDistance(n, "r");
                
                if(leftDistance < RightDistance) {
                    answer.append("L");
                    leftPoint = n;
                }
                else if(RightDistance < leftDistance) {
                    answer.append("R");
                    rightPoint = n;
                }
                else {
                    if(hand.equals("right")) {
                        answer.append("R");
                        rightPoint = n;
                    }
                    else {
                        answer.append("L");
                        leftPoint = n;
                    }
                }
            }
        }
        
        return answer.toString();
    }
    
    public static int getDistance(String n, String h) {
        int target = Integer.parseInt(n);
        int distance = 0;
        
        if(h.equals("l")) {
            distance = dfs(Integer.parseInt(leftPoint), target, 0, 1000);
        }
        else {
            distance = dfs(Integer.parseInt(rightPoint), target, 0, 1000);
        }
        
        return distance;
    }
    
    public static int dfs(int vertex, int target, int visitCnt, int minDistance) {        
        
        if(visit[vertex]) {
            return visitCnt;
        }
        
        visit[vertex] = true;
        
        if(vertex == target) {
            minDistance = Math.min(minDistance, visitCnt);
            return minDistance;
        }
        
        
        Iterator<Integer> iter = table[vertex].iterator();
        while(iter.hasNext()) {
            int nextVertex = iter.next();
            
            if(!visit[nextVertex]) {
                minDistance = dfs(nextVertex, target, visitCnt + 1, minDistance);
            }
        }
        
        return minDistance;
    }
}