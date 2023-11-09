import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ansIdx = 0;
        
        for(int s : score) {
            pq.add(s);
            if(pq.size() > k) pq.poll();
            answer[ansIdx++] = pq.peek();        
        }
        
        return answer;
    }
}