import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] map = new int[11][11];
        boolean[][][][] visited = new boolean[11][11][11][11];
        
        int[] now = {5, 5};
        
        char[] charDir = dirs.toCharArray();
        for(char dir : charDir) {
            int prevX = now[0];
            int prevY = now[1];
            move(now, dir);
            if(prevX == now[0] && prevY == now[1]) continue;
            if(visited[prevX][prevY][now[0]][now[1]]) continue;
            visited[prevX][prevY][now[0]][now[1]] = true;
            visited[now[0]][now[1]][prevX][prevY] = true;
            answer++;
        }
            
        
        return answer;
    }
    
    public void move(int[] now, char dir) {
        if(dir == 'U') {
            if(now[0] - 1 >= 0) {
                now[0] -= 1;    
            }
        } else if(dir == 'L') {
            if(now[1] - 1 >= 0) {
                now[1] -= 1;    
            }
            
        } else if(dir == 'R') {
            if(now[1] + 1 < 11) {
                now[1] += 1;    
            }
        } else {
            if(now[0] + 1 < 11) {
                now[0] += 1;    
            }
        }
            
     }
    
    
}