import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int N;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        bfs(x - 1, y - 1);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(map[a - 1][b - 1]).append(" ");
        }
        System.out.println(sb);
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;
        while (!q.isEmpty()) {
            for(int i = 0, size = q.size(); i < size; i++) {
                int[] now = q.poll();
                for(int j = 0; j < 8; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    map[nx][ny] = map[now[0]][now[1]] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}