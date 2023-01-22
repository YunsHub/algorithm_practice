import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] arr;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        result = 0;

        for(int k = 0; k < H; k++){
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if(arr[k][i][j] == 1) {
                        q.add(new int[] {k, i, j});
                    }
                }
            }
        }
        bfs();
        for(int k = 0; k < H; k++){
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[k][i][j] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    result = Math.max(result, arr[k][i][j]);
                }
            }
        }
        System.out.println(result - 1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 6; i++) {
                int nz = now[0] + dz[i];
                int nx = now[1] + dx[i];
                int ny = now[2] + dy[i];

                if(nz < 0 || nz >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                if(arr[nz][nx][ny] != 0) {continue;}
                arr[nz][nx][ny] = arr[now[0]][now[1]][now[2]] + 1;
                q.add(new int[] {nz, nx, ny});
            }
        }
    }
}