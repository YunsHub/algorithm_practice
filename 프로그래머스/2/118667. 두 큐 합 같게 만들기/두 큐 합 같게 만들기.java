import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {        
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long firstSum = 0;
        long totalSum = 0;
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            firstSum += queue1[i];
            totalSum += queue1[i] + queue2[i];
        }
        
        totalSum /= 2;
        
        while(firstSum != totalSum) {
            if(answer > queue1.length * 2 + 1) return -1;
            if(firstSum < totalSum) {
                int num = q2.poll();
                q1.add(num);
                firstSum += num;
            } else {
                int num = q1.poll();
                q2.add(num);
                firstSum -= num;
            }
            answer++;
        }
        
        
        return answer;
    }
}