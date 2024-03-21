import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        int answer = 0;
        
        for(int n : d) {
            sum += n;            
            if(sum > budget) break;
            answer++;            
        }
        
        
        return answer;
    }
}