import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int lostIndex = 0; lostIndex < lost.length; lostIndex++) {
            for(int reserveIndex = 0; reserveIndex < reserve.length; reserveIndex++) {
                if(lost[lostIndex] == reserve[reserveIndex]) {
                    answer++;
                    lost[lostIndex] = -2;
                    reserve[reserveIndex] = -2;
                    break;
                }
            }            
        }
        
        for(int lostIndex = 0; lostIndex < lost.length; lostIndex++) {
            for(int reserveIndex = 0; reserveIndex < reserve.length; reserveIndex++) {
                if(lost[lostIndex] - 1 == reserve[reserveIndex] ||
                  lost[lostIndex] + 1 == reserve[reserveIndex] ) {
                    answer++;
                    reserve[reserveIndex] = -2;
                    break;
                }
            }            
        }
        
        return answer;
    }
}