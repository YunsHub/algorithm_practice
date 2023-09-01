import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        permutation(0, k, dungeons, visited);        
        return answer;
    }
    public void permutation(int cnt, int k, int[][] dungeons, boolean[] visited) {             for(int index = 0; index < dungeons.length; index++) {        
            if(!visited[index] && k >= dungeons[index][0]) {
                visited[index] = true;
                permutation(cnt + 1, k - dungeons[index][1], dungeons, visited);
                visited[index] = false;
            }
        }
        answer = Math.max(cnt, answer);
    }
}