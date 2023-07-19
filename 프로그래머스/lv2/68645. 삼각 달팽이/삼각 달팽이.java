import java.util.*;
class Solution {
    public int[] solution(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        int[][] snail = new int[n][n];
        int number = 1;
        int x = -1;
        int y = 0;
        for(int rotate = 0; rotate < n; rotate++) {
            for(int j = rotate; j < n; j++) {
                // 아래 
                if(rotate % 3 == 0) {
                    snail[++x][y] = number++;
                }
                // 오른쪽 
                else if(rotate % 3 == 1) {
                    snail[x][++y] = number++;
                } 
                // 위쪽    
                else if(rotate % 3 == 2) {
                    snail[--x][--y] = number++;
                } 
            }        
        }
        int[] answer = new int[sum];
        int idx = 0;
        for(int i = 0; i < snail.length; i++) {
            for(int j = 0; j < snail[i].length; j++) {
                if(snail[i][j] == 0) continue;
                answer[idx++] = snail[i][j];
            }
        }
        return answer;
    }
}