import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1261 {

    static int M;
    static int N;

    static int[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Edge implements Comparable<Edge> {
        int y;
        int x;
        int w;

        public Edge(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        int[][] distances = new int[N + 1][M + 1];

        for (int i = 0; i < distances.length; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        queue.offer(new Edge(1, 1, 0));
        distances[1][1] = 0;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny <= 0 || ny > N || nx <= 0 || nx > M) continue;
                if (distances[ny][nx] < cur.w) continue;

                if (distances[ny][nx] > distances[cur.y][cur.x] + map[ny][nx]) {
                    queue.offer(new Edge(ny, nx, cur.w + map[ny][nx]));
                    distances[ny][nx] = cur.w + map[ny][nx];
                }
            }
        }

        return distances[N][M];
    }
}