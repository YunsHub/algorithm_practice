import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[PLACE_NUM];
        Arrays.fill(answer, 1);
        
        for(int i=0; i<PLACE_NUM; i++) {
            loop: for(int j=0; j<PLACE_NUM; j++) {
                for(int k=0; k<PLACE_NUM; k++) {
                    if(places[i][j].charAt(k) == 'P') {
                        possible = 1;
                        dfs(places, 0, i, j, k, new boolean[PLACE_NUM][PLACE_NUM]);
                        answer[i] = possible;
                        if(possible ==0) break loop;                        
                    }
                }
            }
        }
        
        return answer;
    }
    
    int[] dx = {0, 1, 0};
    int[] dy = {1, 0, -1};
    int DIR_NUM = 3;
    int PLACE_NUM = 5;
    int possible = 1;
    public void dfs(String[][] places, int depth, int i, int x, int y, boolean[][] visited) {        
        if(depth == 2) {
            return;
        }
        
        visited[x][y] = true;        
        for(int dir=0; dir<DIR_NUM; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(!isRange(nx, ny) || places[i][nx].charAt(ny) == 'X' || visited[nx][ny]) continue;
            if(places[i][nx].charAt(ny) == 'P') {
                possible = 0;
                return;
            }
            dfs(places, depth+1, i, nx, ny, visited);
        }        
    }
    
    public boolean isRange(int x, int y) {
        return x>=0 && y>=0 && x<PLACE_NUM && y<PLACE_NUM;  
    }
    
}