import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17086 {

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        result = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0){
                    visited = new boolean[N][M];
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        visited[x][y] = true;
        q.add(new int[]{x, y});
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] position = q.poll();

                if (arr[position[0]][position[1]] == 1) {
                    result = Math.max(result, distance);
                    return;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = position[0] + dx[j];
                    int ny = position[1] + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            distance++;
        }
    }
}
