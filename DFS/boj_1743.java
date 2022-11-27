import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, -1 , 0, 1};
    static int result;
    static int max;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        result = 0;

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r][c] = 1;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    max = 1;
                    dfs(i, j);
                    result = Math.max(result, max);
                }
            }
        }

        System.out.println(result);

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > 0 && ny > 0 && nx <= N && ny <= M){
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    max++;
                    dfs(nx, ny);
                }
            }
        }
    }
}