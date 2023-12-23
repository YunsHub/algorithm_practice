import java.util.*;
class Solution {
    
    public int[][] maps;
    
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {1, 0, -1, 0};
    public int size;
        
    public int solution(int[][] land) {
        int answer = 0;
        int num = 2;
        ArrayList<Integer> sizeList = new ArrayList<>();
        sizeList.add(0);
        sizeList.add(0);
        
        maps = new int[land.length][land[0].length];
        for(int i=0; i <land.length; i++) {
            for(int j =0; j < land[0].length; j++) {
                maps[i][j] = land[i][j];
            }
        }
        
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                if(maps[i][j]==1) {
                    size = 0;
                    dfs(num, i, j);
                    num++;
                    sizeList.add(size);
                }
            }
        }
        //System.out.println(Arrays.deepToString(maps));
        
        
        for(int i = 0; i < maps[0].length; i++) {
            boolean[] visited = new boolean[sizeList.size()];
            int sum = 0;
            for(int j = 0; j < maps.length; j++) {
                //System.out.println(i + " "+j);
                if(visited[maps[j][i]]) continue;
                visited[maps[j][i]] = true;
                sum += sizeList.get(maps[j][i]);
            }
            answer = Math.max(answer, sum);
        }
        
        
        return answer;
    }
    
    public void dfs(int num, int x, int y) {
        maps[x][y] = num;
        size++;
        
        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length) continue;
            if(maps[nx][ny]!=1) continue;
            dfs(num, nx, ny);
        }
        
    }
}