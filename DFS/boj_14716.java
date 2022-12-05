import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14716 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        count = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
    }
}
