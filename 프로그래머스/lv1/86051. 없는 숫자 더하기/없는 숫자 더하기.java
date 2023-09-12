import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] number = new int[10];
        for(int num : numbers) number[num]++;
        for(int i = 0; i < 10; i++) {
            if(number[i] == 0) answer += i;
        }
        return answer;
    }
}