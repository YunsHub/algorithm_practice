import java.util.*;
class Solution {
    public int solution(int n) {
        int div = (int) Math.sqrt(n);
        int answer = 0;
        for(int i=1; i<=div; i++) {
            if(i * i == n) answer += i;
            else if(n % i == 0) {
                answer += i;
                answer += (n / i);
            }
        }
        
        
        return answer;
    }
}