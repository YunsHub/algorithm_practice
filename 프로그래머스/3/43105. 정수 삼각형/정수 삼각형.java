import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][len];
                        
        int top = triangle[0][0];
        // if(len==1) return top;
        
        dp[0][0] = top;
        dp[1][0] = top + triangle[1][0];
        dp[1][1] = top + triangle[1][1];
        
        for(int i=2; i<len; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            for(int j=1; j<i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
            
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        int answer = 0;
        for(int i=0; i<len; i++) {
            answer = Math.max(answer, dp[len-1][i]);
        }
        
        return answer;
        
        
        
        
        
        
        
        
        
        
        
        
        
        // int answer = triangle[0][0];
        // for(int i = 1; i < triangle.length; i++) {
        //     for(int j = 0; j < triangle[i].length; j++) {
        //         if(j == 0) triangle[i][j] += triangle[i - 1][j];
        //         else if(j == triangle[i].length - 1) triangle[i][j] += triangle[i - 1][j - 1];
        //         else triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
        //     }
        // }
        // for(int i = 0; i < triangle.length; i++) {
        //     System.out.println(triangle[triangle.length - 1][i]);
        //     answer = Math.max(answer, triangle[triangle.length - 1][i]);
        // }
        // return answer;
    }
}