import java.util.*;
class Solution {
    
    int answer = Integer.MAX_VALUE;
    int[][] block = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {        
        
        
        int pickCnt = 0;
        for(int cnt : picks) pickCnt += cnt;
    
         dfs(new int[pickCnt], 0, picks, minerals);
        
        return answer;
    }
    
    public void dfs(int[] sup, int cnt, int[] picks, String[] minerals) {
        if(cnt == sup.length) {
            answer = Math.min(answer, getStat(sup, minerals));
            return;
        }
        
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] > 0) {
                picks[i]--;
                sup[cnt] = i;
                dfs(sup, cnt + 1, picks, minerals);
                picks[i]++;
            }
        }
        
        return;        
    }
    
    public int getStat(int[] sup, String[] minerals) {
        Map<String, Integer> mineralMap = new HashMap<>();
        mineralMap.put("diamond", 0);
        mineralMap.put("iron", 1);
        mineralMap.put("stone", 2);
        
        int stat = 0;
        int idx = 0;
        int num = sup[idx];
        
        for(int i = 0; i < minerals.length; i++) {            
            stat += block[num][mineralMap.get(minerals[i])];
            
            if((i+1) % 5 == 0) {
                if(idx >= sup.length - 1) break;
                num = sup[++idx];
            }    
        }
        return stat;
    }
}