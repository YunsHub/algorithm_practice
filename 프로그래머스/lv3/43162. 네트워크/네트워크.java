import java.util.*;
class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];    
        for(int index = 0; index < n; index++) {
            if(!visited[index]) {
                dfs(index, visited, computers);
                answer++;
            }
        }
        
        return answer;
    }
    public void dfs(int start, boolean[] visited, int[][] computers) {
        visited[start] = true;
        for(int index = 0; index < computers.length; index++) {
            if(!visited[index] && computers[start][index] == 1) dfs(index, visited, computers);
        }
    }
}