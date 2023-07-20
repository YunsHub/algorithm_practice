import java.util.*;
class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        bfs(0, 0, maps, visited);
        int answer = maps[maps.length - 1][maps[0].length - 1];
        if(maps[maps.length - 1][maps[0].length - 1] == 1) answer = -1;
        System.out.println(Arrays.deepToString(maps));
        return answer;
    }
    public void bfs(int x, int y, int[][] maps, boolean[][] visited) {
        Queue<int[]> mapQueue = new LinkedList<>();
        mapQueue.add(new int[] {x, y});
        visited[x][y] = true;
        while(!mapQueue.isEmpty()) {
            int[] next = mapQueue.poll();
            for(int dir = 0; dir < 4; dir++) {
                int nx = next[0] + dx[dir];
                int ny = next[1] + dy[dir];
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length
                   || visited[nx][ny] || maps[nx][ny] == 0) continue;
                mapQueue.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                maps[nx][ny] += maps[next[0]][next[1]];
            }
        }
    }
    
}