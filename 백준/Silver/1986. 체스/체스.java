import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] qx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] qy = {1, 0, -1, -1, -1, 0, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        for (int j = 0; j < Q; j++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = 1;
        }
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int j = 0; j < K; j++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = 2;
        }
        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        for (int j = 0; j < P; j++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = 3;
        }

        solve();
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    result++;
                }
            }
        }
        System.out.println(result);
        //System.out.println(Arrays.deepToString(arr));

    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 퀸
                if (arr[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int cnt = 0;
                        while (true) {
                            cnt++;
                            int nx = i + qx[k] * cnt;
                            int ny = j + qy[k] * cnt;
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1 || arr[nx][ny] == 2 || arr[nx][ny] == 3) {
                                break;
                            }
                            arr[nx][ny] = -1;
                        }
                    }
                }
                // 나이트
                else if (arr[i][j] == 2) {
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != 0) {
                            continue;
                        }
                        arr[nx][ny] = -1;
                    }
                }
            }
        }
    }
}