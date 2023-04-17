import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] time;
    static int[][] fireTime;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<int[]> jihun = new LinkedList<>();
    static Queue<int[]> fire = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        time = new int[N][M];
        fireTime = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J') {
                    map[i][j] = '.';
                    jihun.add(new int[] {i, j});
                } else if(map[i][j] == 'F') {
                    fire.add(new int[] {i, j});
                }
            }
        }
        bfs();

        System.out.println("IMPOSSIBLE");

    }
    public static void bfs() {
        while (!jihun.isEmpty()) {
            for(int i = 0, size = fire.size(); i < size; i++) {
                int[] now = fire.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
                    map[nx][ny] = 'F';
                    fire.add(new int[] {nx, ny});
                }
            }

            for(int i = 0, size = jihun.size(); i < size; i++) {
                int[] now = jihun.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        System.out.println(time[now[0]][now[1]] + 1);
                        System.exit(0);
                    }
                    if(map[nx][ny] != '.' || time[nx][ny] != 0) continue;
                    time[nx][ny] = time[now[0]][now[1]] + 1;
                    jihun.add(new int[] {nx, ny});
                }
            }

        }
    }

}