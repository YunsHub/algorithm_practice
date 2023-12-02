import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int answer = 1;
    public static int[][] map;
    public static boolean[] check;
    public static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[26];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        check[map[0][0]] = true;
        dfs(1, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!isRange(nx, ny)) continue;
            if (check[map[nx][ny]]) {
                answer = Math.max(answer, depth);
                continue;
            }
            check[map[nx][ny]] = true;
            dfs(depth + 1, nx, ny);
            check[map[nx][ny]] = false;
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}