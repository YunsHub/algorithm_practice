import java.util.*;
class Solution {
    
    int DIR = 4;
    int N = 0;
    int M = 0;
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};    
    Map<Integer, String> map = new HashMap<>();
    String answer = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {                
        
        // 불가능
        int diffX = Math.abs(x-r);
        int diffY = Math.abs(y-c);
        if(diffX + diffY > k || (diffX+diffY) % 2 != k % 2) return "impossible";
        
        // init
        N = n;
        M = m;
        map.put(0, "d");
        map.put(1, "l");
        map.put(2, "r");
        map.put(3, "u");
        
        // dfs
        dfs(new StringBuilder(), 0, k, x, y, r, c);
        
        return answer;
    }
    
    
    public boolean dfs(StringBuilder sb, int depth, int k, int x, int y, int r, int c) {
        if(!check(x, y, r, c, k, depth)) return false;
            
        if(depth == k) {                 
            if(x == r && y == c) answer = sb.toString();
            return false;
        }
              
        for(int dir=0; dir<DIR; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(!isRange(nx, ny)) continue;
            sb.append(map.get(dir));
            if(dfs(sb, depth+1, k, nx, ny, r, c)) break;
            sb.deleteCharAt(sb.length() - 1);
        }           
        
        return true;
    }
    
    public boolean check(int x, int y, int r, int c, int k, int depth) {
        int diffX = Math.abs(x - r);
        int diffY = Math.abs(y - c);        
        if(diffX + diffY > k - depth) return false;  
        return true;
    }
    
    public boolean isRange(int x, int y) {
        return x>0 && y>0 && x<=N && y<=M;
    }
}