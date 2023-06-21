import java.util.*;
class Solution {
    // 1. 종류 구하고 완탐으로 길이 짧은 거 구하기 (효율성 막힐 것 같음), gems 길이만큼 나오면 stop
// 슬라이딩 윈도우?
    
    // 다이아 1 4 5
    // 루비 2 3
    // 에메랄드 6
    // 사파이어 7
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = gems.length;
        Set<String> set = new HashSet<>();        
        for(int i = 0; i < gems.length; i++) {
            set.add(gems[i]);    
        }
    
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        int s = 0;
        int e = 0;
        for(int i = 0; i < gems.length; i++) {                        
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            while(map.get(gems[s]) > 1) {
                map.put(gems[s], map.get(gems[s]) - 1);
                s++;
            }
            if(map.size() == set.size() && i - s < min)  {
                answer[0] = s + 1;
                answer[1] = i + 1;            
                min = i - s;            
            }
        }
       
                
        return answer;
    }
}