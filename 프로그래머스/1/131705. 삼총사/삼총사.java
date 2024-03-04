import java.util.*;
class Solution {
    // 0 0 0 0 0 1 1 1 1 1 1 1 1
    int answer = 0;        
    boolean[] visited;
    public int solution(int[] number) {        
        int len = number.length;
        visited = new boolean[len];
        comb(0, 0, number, 0);
        return answer;
    }
    
    public void comb(int idx, int cnt, int[] number, int sum) {
        if(cnt == 3) {
            if(sum==0) answer++;
            return;
        }
        
        for(int i=idx; i<number.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1, cnt+1, number, sum + number[i]);
                visited[i] = false;
            }
        }
    }
}