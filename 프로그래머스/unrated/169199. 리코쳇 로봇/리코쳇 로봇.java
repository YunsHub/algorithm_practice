import java.util.*;
class Solution {
    public int[] dx = {1, 0 , -1, 0};
    public int[] dy = {0, -1, 0, 1};
    public class Node {
        int x;
        int y;
        int cnt;
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(String[] board) {
        int[][] maps = new int[board.length][board[0].length()];
        int sx = 0;
        int sy = 0;
        int gx = 0;
        int gy = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    sx = i;
                    sy = j;
                } else if(board[i].charAt(j) == 'G') {
                    gx = i;
                    gy = j;
                }
            }
        }
        
        //System.out.println(Arrays.deepToString(maps));
        return bfs(board, maps, sx, sy, gx, gy);
    }
    public int bfs(String[] board, int[][] maps, int sx, int sy, int gx, int gy) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy, 1));
        maps[sx][sy] = -1;        
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                int cnt = now.cnt;
                
                while(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length
                  && board[nx].charAt(ny) != 'D'
                  ) {
                    nx += dx[dir];
                    ny += dy[dir];
                }         
                
                if(dir == 0) nx--;
                else if(dir == 1) ny++;
                else if(dir == 2) nx++;
                else ny--;
                
                if(maps[nx][ny] != 0) continue;
                if(board[nx].charAt(ny) == 'G') return cnt;
                maps[nx][ny] = cnt;
                q.add(new Node(nx, ny, cnt + 1));
                //System.out.println(cnt + " "+ nx + " " + ny);
                
            }         
        }
        return -1;
    }
}