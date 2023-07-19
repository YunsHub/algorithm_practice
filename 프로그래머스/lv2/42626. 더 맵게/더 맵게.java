import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovillePriorityQueue = new PriorityQueue<>();
        int answer = 0;
        for(int foodScoville : scoville) {
            scovillePriorityQueue.add(foodScoville);
        }
        while(scovillePriorityQueue.size() > 1 && scovillePriorityQueue.peek() < K) {
            scovillePriorityQueue.add(scovillePriorityQueue.poll()
                                      + (scovillePriorityQueue.poll() * 2));
            answer++;            
        }    
        if(scovillePriorityQueue.poll() < K) {
            answer = -1;
        }
        return answer;
    }
}