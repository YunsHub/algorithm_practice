import java.util.*;
class Solution {
    public int[] solution(int n, int[] info) {
        // 각 점수를 획득했을 경우, 안했을 경우 2가지
        dfs(n, 0, 0, info);
        
        for(int i=0; i<10; i++) {
            if(ans[i] != 0) {
                return ans;
            }
        }
        return new int[] {-1};
    }
    
    int[] ans = new int[11];
    int[] score = new int[11];
    int maxScore = 1;
    
    public void dfs(int n, int now, int cnt, int[] info) {
        if(cnt == n || now == 11) {
            // System.out.println(Arrays.toString(score));
            int nowScore = getScore(info);
            
            if(nowScore >= maxScore) {
                if(nowScore == maxScore && lowCnt()) {
                    return;
                }
                
                maxScore = nowScore;
                ans = score.clone();
                ans[10] += (n-cnt);
            }
            return;
        }
        
        dfs(n, now + 1, cnt, info);
        
        if(cnt + info[now] + 1 <= n) {
            int ryanScore = info[now] + 1;
            score[now] = ryanScore;
            dfs(n, now + 1, cnt+ryanScore, info);
            score[now] = 0;
        }
    }
    
    public int getScore(int[] info) {
        int ryanScore = 0;
        int apeachScore = 0;
        
        for(int i=0; i<11; i++) {
            if(score[i] != 0) {
                ryanScore += (10-i);
            } else if(info[i] > 0) {
                apeachScore += (10-i);
            }
        }
        return ryanScore - apeachScore;
    }
    
    public boolean lowCnt() {
        int nowCnt = 0;
        int ansCnt = 0;
        
        for(int i=10; i>=0; i--) {
            if(score[i] != 0) nowCnt++;
            if(ans[i] != 0) ansCnt++;
            
            if(nowCnt == ansCnt) continue;
            
            if(nowCnt < ansCnt) return true;
            else return false;
        }
        
        return false;
    }
}