import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {            
        int answer = 0;
        Arrays.sort(score);
        int cnt = score.length;
        while(true) {            
            cnt -= m;
            if(cnt < 0)  break;
            answer += (score[cnt] * m);
        }        

        return answer;
    }
}