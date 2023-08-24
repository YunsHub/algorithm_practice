import java.util.*;
class Solution {
    int solution(int[][] land) {
    
        for(int row = 1; row < land.length; row++) {
            for(int col = 0; col < 4; col++) {
                land[row][col] += Math.max(Math.max(land[row - 1][(col + 1) % 4], 
                                                    land[row - 1][(col + 2) % 4]), 
                                           land[row - 1][(col + 3) % 4]);
            }
        }
        
        
        int answer = 0;
        for(int index = 0; index < 4; index++) {
            answer = Math.max(answer, land[land.length - 1][index]);
        }
        return answer;
    }
}