import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int number = left; number <= right; number++) {
            int cnt = getNum(number);
            if(cnt % 2 == 0) answer += number;
            else answer -= number;
        }
        return answer;
    }
    public int getNum(int num) {
        int cnt = 0;
        int sqrt = (int) Math.sqrt(num);
        for(int i = 1; i <= sqrt; i++) {
            if(num % i == 0) {
                cnt++;
                if(num / i != i) cnt++;
            }
        }
        return cnt;
    }
}