class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // idx, deliveryCnt, pickupCnt 변수를 선언한다.
        // 배열의 뒷부분 부터 돌면서        
        // 시작지점 찾기(idx 초기값)
        // 만약 배달 개수 or 픽업 개수가 cap을 초과하거나 물류센터에 도착하면
        // 저장한 idx를 answer에 더하기
        // answer * 2 return
        
        long answer = 0;
        int deliveryMaxCnt = cap, pickupMaxCnt = cap;
        int idx = 0;
        
        // 시작 지점 초기화
        for(int i=n-1; i>=0; i--) {
            if(deliveries[i] != 0 || pickups[i] != 0) {
                idx = i;
                break;
            }
        }
        
        // 0 0 0 4 0
        // 0 5 0 0 0
        
        // 0 0 0 9 0
        // 0 0 5 0 0
        
        for(int i=idx; i>=0; i--) {          
            deliveryMaxCnt -= deliveries[i];
            pickupMaxCnt -= pickups[i];
            //System.out.println(deliveryMaxCnt + " " + pickupMaxCnt);
            while(deliveryMaxCnt < 0 || pickupMaxCnt < 0) {
                deliveryMaxCnt += cap;
                pickupMaxCnt += cap;
                answer += (idx+1);
                idx = i;
            }                
        }        
        
        if(answer == 0) return 0;
        
        answer+=(idx+1);
        
        return answer*2;
    }
}