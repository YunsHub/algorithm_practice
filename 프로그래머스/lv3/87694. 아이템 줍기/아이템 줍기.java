import java.util.*;
class Solution {
    public int[] dx = {1, 0 , -1, 0};
    public int[] dy = {0, -1 , 0, 1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] maps = new int[102][102];
        for(int index = 0; index < rectangle.length; index++) {
            int sx = rectangle[index][0] * 2;
            int sy = rectangle[index][1] * 2;
            int ex = rectangle[index][2] * 2;
            int ey = rectangle[index][3] * 2;
            
            for(int i = sx; i <= ex; i++) {
                for(int j = sy; j <= ey; j++) {
                    if(maps[i][j] == -1) continue;
                    if(i == sx || i == ex || j == sy || j == ey) maps[i][j] = 1;
                    else maps[i][j] = -1;
                }
            }
        }
        bfs(maps, characterX * 2, characterY * 2); 
        return maps[itemX * 2][itemY * 2] / 2;
    }
    
    public void bfs(int[][] maps, int characterX, int characterY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {characterX, characterY});
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int dir = 0; dir < 4; dir++) {                
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                if(maps[nx][ny] != 1) continue;
                maps[nx][ny] += maps[now[0]][now[1]];                
                q.add(new int[] {nx, ny});
            }
        }
    }
}