import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovillePriorityQueue = new PriorityQueue<>();
        int answer = 0;
        for(int foodScoville : scoville) {
            scovillePriorityQueue.add(foodScoville);
        }
        while(!scovillePriorityQueue.isEmpty() && scovillePriorityQueue.peek() < K) {
            int lowScoville1 = scovillePriorityQueue.poll();
            if(!scovillePriorityQueue.isEmpty()) {
                int lowScoville2 = scovillePriorityQueue.poll();
                scovillePriorityQueue.add(lowScoville1 + (lowScoville2 * 2));
                answer++;
                continue;
            }
            if(lowScoville1 < K) {
                answer = -1;
                break;
            }
            
        }    
        
        return answer;
    }
}