import java.util.*;
class Solution {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, -1, 0, 1};
    public int solution(String[] maps) {
        //boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int sx = 0;
        int sy = 0;
        int ex = 0;
        int ey = 0;
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                 if(maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if(maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                } 
            }            
        }
        //dfs(0, maps, visited, x, y);        
        
        return bfs(maps, sx, sy, ex, ey);
    }
    
    public int bfs(String[] maps, int sx, int sy, int ex, int ey) {
        int[][] map = new int[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sx, sy});
        boolean result = false;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length() || 
                  map[nx][ny] != 0 || maps[nx].charAt(ny) == 'X') continue;
                if(maps[nx].charAt(ny) == 'L') {    
                    result = true;
                    int dis = map[now[0]][now[1]] + 1;
                    map = new int[maps.length][maps[0].length()];
                    map[nx][ny] = dis;
                    q.clear();
                    q.add(new int[] {nx, ny});
                    break;
                } else {
                    map[nx][ny] = map[now[0]][now[1]] + 1; 
                    q.add(new int[] {nx, ny});
                }
                
            }
        }
        System.out.println(Arrays.deepToString(map));
        if(map[ex][ey] == 0 || !result) return -1;
        else return map[ex][ey];
    }
    
    // public int dfs(int depth, String[] maps, boolean[][] visited, int x, int y) {
    //     System.out.println(depth  +" " + x + " " + y);
    //     visited[x][y] = true;
    //     for(int dir = 0; dir < 4; dir++) {
    //         int nx = x + dx[dir];
    //         int ny = y + dy[dir];
    //         if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps.length ||
    //           visited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;        
    //         if(maps[nx].charAt(ny) == 'L') {
    //             visited = new boolean[maps.length][maps[0].length()];
    //         }
    //         dfs(depth + 1, maps, visited, nx, ny);
    //     }
    // }
}