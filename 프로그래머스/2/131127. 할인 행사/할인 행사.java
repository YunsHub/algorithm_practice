import java.util.*;

class Solution {
    
    Map<String, Integer> wantMap; 
    
    public int solution(String[] want, int[] number, String[] discount) {
        // want[]:품목, number[]:품목별 개수, discount[]:할인품목
        // number의 총합은 10
        // 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return
        
        // 각 want와 number를 hashMap<String, Integer>에 저장
        // discount[]에서 0~10번까지 품목별 number-- 저장
        // hashMap number가 모두 0이면 answer++ 
        // 0번 11번 index가 같으면 answer++
        // 아니면 0번 index는 +1, 11번 index는 -1
        // number 0인지 검사 
        
        // init
        int answer = 0;
        wantMap = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // cal
        for(int i=0; i<discount.length; i++) {
            String food = discount[i];
            
            if(i >= 10) {
                String prevFood = discount[i-10];
                if(wantMap.containsKey(prevFood)) {
                    wantMap.put(prevFood, wantMap.get(prevFood) + 1);            
                }                    
            } 
            
            if(wantMap.containsKey(food)) {                
                wantMap.put(food, wantMap.get(food) - 1);
            }            
            
            if(isAllDiscount()) {
                answer++;
            }                    
        }        
        
        // wantMap.forEach((key, value) -> {
        //     System.out.println(key + " " + value);
        // });            
        
        return answer;
    }
    
    public boolean isAllDiscount() {
        for(String key : wantMap.keySet()) {
            if(wantMap.get(key) != 0) {
                return false;
            }
        }
        
        return true;
    }
}