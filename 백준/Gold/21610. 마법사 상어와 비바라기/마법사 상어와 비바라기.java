import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        // 구름 초기화
        visited[n - 1][0] = true;
        visited[n - 1][1] = true;
        visited[n - 2][0] = true;
        visited[n - 2][1] = true;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m ;i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int dis = Integer.parseInt(st.nextToken());
            simulation(dir, dis % n);
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);

    }

    public static void simulation(int dir, int dis) {
        // 1. 구름이 이동
        // 2. 구름이 이동 후 각 칸의 물의 양 + 1
        findCloud(dir, dis);
        // 3. 구름이 사라짐
        // 4. 구름이 사라진 칸의 대각선 거리 1인 칸의 물이 있으면 + 칸 수
        addWater();
        // 5. 모든 칸에서 물의 양이 2이상이면 구름 생성, 구름이 사라진 칸은 제외
        addCloud();
    }

    public static void findCloud(int dir, int dis) {
        boolean[][] nextVisited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) {
                    moveCloud(i, j, dir, dis, nextVisited);
                }
            }
        }
        visited = nextVisited;
    }

    public static void moveCloud(int x, int y, int dir, int dis, boolean[][] nextVisited) {
        int nextX = (n + x + (dx[dir] * dis)) % n;
        int nextY = (n + y + (dy[dir] * dis)) % n;
        nextVisited[nextX][nextY] = true;
        map[nextX][nextY]++;
    }

    public static void addWater() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) {
                    searchDir(i, j);
                }
            }
        }
    }

    public static void searchDir(int x, int y) {
        for(int i = 1; i < 8; i+=2) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(isRange(nextX, nextY) && map[nextX][nextY] > 0) {
                map[x][y]++;
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    public static void addCloud() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) visited[i][j] = false;
                else if(map[i][j] >= 2) {
                    visited[i][j] = true;
                    map[i][j] -= 2;
                }
            }
        }
    }





}