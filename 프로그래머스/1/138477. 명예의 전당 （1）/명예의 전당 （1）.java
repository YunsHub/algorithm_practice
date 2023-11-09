import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ansIdx = 0;
        
        for(int s : score) {
            if(pq.size() < k) {
                pq.add(s);                
            } else {
                if(pq.peek() < s) {
                    pq.poll();
                    pq.add(s);
                }
            }
            answer[ansIdx++] = pq.peek();        
        }
        
        return answer;
    }
}