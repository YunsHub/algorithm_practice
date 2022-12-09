import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1189 {
    static int R, C, K;
    static char[][] arr;
    static boolean[][] visited;
    static int result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];
        result = 0;

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(result);
    }

    public static void dfs(int x, int y, int depth) {

        if (x == 0 && y == C - 1 && depth == K) {
            result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visited[nx][ny] && arr[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    dfs(nx, ny, depth + 1);
                    visited[nx][ny] = false;
                }
            }
        }

    }
}
