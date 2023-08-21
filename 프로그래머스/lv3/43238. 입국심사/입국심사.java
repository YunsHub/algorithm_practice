import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long min = 1;
        long max = (long) times[times.length - 1] * n;
        
        while(min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for(int time : times) {
                sum += (mid / time);
            }
            if(sum >= n) {
                answer = mid;
                max = mid - 1;
            } else if(sum < n) {
                min = mid + 1;
            } 
        }
        
        return answer;
    }
}