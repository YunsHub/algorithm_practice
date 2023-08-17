import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {        
        int answer = 0;
        int cnt = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(tangerine);
        int num = tangerine[0];
        for(int index = 1; index < tangerine.length; index++) {
            if(num == tangerine[index]) {
                cnt++;
            } 
            else {
                pq.add(cnt);
                cnt = 1;
                num = tangerine[index];
            }
        }
        pq.add(cnt);
       
        while(k > 0 && !pq.isEmpty()) {
            k -= pq.poll();
            answer++;
        }
        
        return answer;
    }
}