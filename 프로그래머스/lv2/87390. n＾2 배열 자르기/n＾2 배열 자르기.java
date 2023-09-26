import java.util.*;
class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = new long[(int)right - (int)left +1];
        int index = 0;
        for(long i = left; i <= right; i++) {
            answer[index++] = Math.max(i / n , i % n) + 1;
        }        
        
        
        return answer;
    }
}