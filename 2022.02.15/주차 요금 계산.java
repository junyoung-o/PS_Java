// 조건
// 1. 출차 없으면 23:59 출차
// 2. 기본시간 이하 : 기본 요금
// 3. 기본시간 초과 : 올림 후 단위 요금 적용 (기본요금 + [(주차 시간 - 기본시간)/단위시간] * 단위요금) 

// 입력
// fees = {기본시간, 기본요금, 단위시간, 단위요금}
// records = {시간, 번호, 입/출}

import java.util.*;

class Solution {
    HashMap<String, String> timeDict;
    HashMap<String, String> stateDict;
    
    HashMap<String, Integer> storeDict;

    
    
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        timeDict = new HashMap<>();
        stateDict = new HashMap<>();
        
        storeDict = new HashMap<>();
        
        for(String r : records) {
            String[] info = r.split(" ");
            
            if(stateDict.keySet().contains(info[1]) && stateDict.get(info[1]).equals("IN")) {
                int pTime = storeDict.get(info[1]);
                
                int cTime = getTime(info[1], info[0]);                
                
                int sTime = cTime + pTime;
                
                storeDict.replace(info[1], sTime);
                stateDict.put(info[1], info[2]);
                
            }
            
            else {
                timeDict.put(info[1], info[0]);
                stateDict.put(info[1], info[2]);
                if(!storeDict.keySet().contains(info[1])) {
                    storeDict.put(info[1], 0);
                }
            }
        }
        
        // Out log 없는 친구 계산
        for(String carNumber : stateDict.keySet()) {
            if(!stateDict.get(carNumber).equals("OUT")) {
                int cTime = extraStateTime(timeDict.get(carNumber));
                int pTime = storeDict.get(carNumber);
                int sTime = cTime + pTime;
                storeDict.replace(carNumber, sTime);
            }
        }
        
        // storeDict에 누적 시간 있음
        // price 계산
        ArrayList<String> orderedCarNumber = new ArrayList(storeDict.keySet());
        Collections.sort(orderedCarNumber);
        
        for(String carNumber : orderedCarNumber) {
            int price = getPrice(fees, storeDict.get(carNumber));
            answer.add(price);
            // System.out.println(carNumber + " : " + storeDict.get(carNumber) + ", " + price);
            
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
    public int getTime(String carNumber, String time) {
        String[] preTime = timeDict.get(carNumber).split(":");
        String[] currentTime = time.split(":");
        
        
        int h = Integer.parseInt(currentTime[0]) - Integer.parseInt(preTime[0]);
        int m = Integer.parseInt(currentTime[1]) - Integer.parseInt(preTime[1]);
        
        if(m < 0) {
            h -= 1;
            m += 60;
        }
        
        return (h*60) + m;
    }
    
    public int getPrice(int[] fees, int time) {
        if(time <= fees[0]) {
            return fees[1];
        }        
        int price = fees[1] + myCeil((time - fees[0]) / (float)fees[2]) * fees[3];
        return price;
        
    }
    
    public int extraStateTime(String time) {
        String[] currentTime = time.split(":");
        
        int h = 23 - Integer.parseInt(currentTime[0]);
        int m = 59 -  Integer.parseInt(currentTime[1]);
        
        if(m < 0) {
            h -= 1;
            m += 60;
        }
        
        return (h*60) + m;
    }
    
    public int myCeil(float x) {
        // System.out.println(x);
        if((x * 10 ) % 10 != 0) {
            return (int)x + 1;
        }
        return (int)x;
    }
    
}