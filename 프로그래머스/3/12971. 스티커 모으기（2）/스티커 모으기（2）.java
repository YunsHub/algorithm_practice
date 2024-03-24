import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        if(len==1) return sticker[0];
        int[] dp = new int[len];
        int[] dp2 = new int[len];
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2; i<len; i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        for(int i=2; i<len; i++) {
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
        }
        // 14 6 5 11 3 9 2 10
        // idx - 2 + sticker[idx], sticker[idx-1] 
        // 14 6 19 19 22 28 28 38
        // 14 6 5 17 17 26 26 36
        // System.out.println(Arrays.toString(dp2));
        // System.out.println(Arrays.toString(dp));
        return (int) Math.max(dp[len-2], dp2[len-1]);
    }
    
}