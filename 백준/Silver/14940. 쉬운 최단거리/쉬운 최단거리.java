import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        arr = new int[N][M];
        visited = new boolean[N][M];
        int[] start = new int[1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new int[]{i, j};
                } else if (map[i][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        bfs(start[0], start[1]);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        arr[x][y] = 0;
        int result = 1;

        while (!q.isEmpty()) {
            for (int i = 0, size = q.size(); i < size; i++) {
                int[] now = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] != 1) {
                        continue;
                    }
                    visited[nx][ny] = true;
                    arr[nx][ny] = result;
                    q.add(new int[]{nx, ny});
                }
            }
            result++;
        }
    }
}