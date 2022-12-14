import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int result;
    static Queue<Node> q;
    public static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();
        result = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        loop:for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                result = Math.max(result, arr[i][j]);
                if(arr[i][j] == 0) {
                    result = 0;
                    break loop;
                }
            }
        }

        System.out.println(result - 1);
    }

    // 최소 일수를 구해야 하므로 BFS를 활용하였다.

    public static void bfs(){
        while (!q.isEmpty()){
            Node now = q.poll();
            int nx = now.x;
            int ny = now.y;

            for(int i = 0; i < 4; i++){
                int ox = nx + dx[i];
                int oy = ny + dy[i];

                if(ox >= 0 && oy >= 0 && ox < N && oy < M) {
                    if(!visited[ox][oy] && arr[ox][oy] == 0) {
                        q.add(new Node(ox, oy));
                        arr[ox][oy] = arr[nx][ny] + 1;
                        visited[ox][oy] = true;
                    }
                }
            }
        }
    }
}
