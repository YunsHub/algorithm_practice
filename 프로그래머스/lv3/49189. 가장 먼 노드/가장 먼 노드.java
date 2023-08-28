import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            list[start].add(end);
            list[end].add(start);
        }       
        return bfs(n, list);
    }    
    public static int bfs(int n, ArrayList<Integer>[] list) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        q.add(new int[] {1, 0});
        int maxDepth = 0;
        int distance = 0;
        while(!q.isEmpty()) {
            int[] vertex = q.poll();        
            int node = vertex[0];
            int depth = vertex[1];
            if(depth == maxDepth) distance++;
            else if(maxDepth < depth) {
                maxDepth = depth;
                distance = 1;
            }
            for(int index = 0; index < list[node].size(); index++) {                
                int num = list[node].get(index);  
                if(!visited[num]) {       
                    q.add(new int[] {num, depth + 1});
                    visited[num] = true;
                }
            }
        }
        return distance;
    }
}