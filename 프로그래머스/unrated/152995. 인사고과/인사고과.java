import java.util.*;
class Solution {
    public int solution(int[][] scores) {        
        int[] wanhoScore = scores[0];
        Arrays.sort(scores, (o1, o2) -> {
            if(o2[0] == o1[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });                
        int maxScore = scores[0][1];
        for(int i = 1; i < scores.length; i++) {
            if(scores[i][1] < maxScore) {
                if(wanhoScore[0] == scores[i][0] && wanhoScore[1] == scores[i][1]) return -1;
                scores[i][0] = 0;
                scores[i][1] = 0;
            } else maxScore = scores[i][1];
        }
                
        int answer = 1;
        int score = wanhoScore[0] + wanhoScore[1];
        for(int i = 0; i < scores.length; i++) {
            if(score < scores[i][0] + scores[i][1]) answer++;
        }
        
        
        return answer;
    }
}