import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();
        int answer = 1;
        for(int index = 0; index < clothes.length; index++) {
            clothesMap.put(clothes[index][1], clothesMap.getOrDefault(clothes[index][1], 0) + 1);            
        }        
        
        for(String key : clothesMap.keySet()) {
            int value = clothesMap.get(key);
            answer *= (value + 1);
        }
        
        
        return answer - 1;
    }
}