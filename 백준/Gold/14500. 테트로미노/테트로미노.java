import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int answer = 0;
    public static int[][] map;
    public static boolean[][] visited;
    public static int n,m,max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        max = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dfs(1, i, j ,map[i][j]);
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int depth, int x, int y, int sum) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        if(depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        if(answer >= sum + max * (4-depth)) return;

        visited[x][y] = true;

        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!isRange(nx, ny)) continue;
            if(visited[nx][ny]) continue;

            if(depth == 2) {
                visited[nx][ny] = true;
                dfs(depth+1, x, y, sum + map[nx][ny]);
                visited[nx][ny] = false;
                visited[x][y] = true;
            }

            dfs(depth+1, nx, ny, sum + map[nx][ny]);
        }

        visited[x][y] = false;
    }

    public static boolean isRange(int x, int y) {
        return x>=0 && y>=0 && x<n && y<m;
    }
}