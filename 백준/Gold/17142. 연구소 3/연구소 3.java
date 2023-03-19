import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 조합으로 활성 바이러스 수를 구한다
// bfs()를 돌린다
// 최소 시간을 구한다.

public class Main {
    static int N, M;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static ArrayList<Virus> virusList = new ArrayList<>();
    static boolean[] visitedComb;
    static int min;
    static int wall;

    public static class Virus {
        int x;
        int y;
        boolean use;

        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        min = Integer.MAX_VALUE;
        wall = 0;


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    wall++;
                }
                else if(map[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                }
            }
        }

        if(wall == 0) {
            System.out.println(0);
            System.exit(0);
        }

        visitedComb = new boolean[virusList.size()];
        comb(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    public static void comb(int idx, int cnt) {
        if(cnt == M) {
            for(int i = 0; i < virusList.size(); i++) {
                if(visitedComb[i]) {
                    virusList.get(i).use = true;
                }
            }
            bfs();
            for(int i = 0; i < virusList.size(); i++) {
                virusList.get(i).use = false;
            }
            return;
        }
        for(int i = idx; i < virusList.size(); i++) {
            if(!visitedComb[i]) {
                visitedComb[i] = true;
                comb(i + 1, cnt + 1);
                visitedComb[i] = false;
            }
        }
    }

    public static void bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int wallCnt = wall;
        int time = 0;
        boolean[][] visitedVirus = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < virusList.size(); i++) {
            if(virusList.get(i).use) {
                q.add(new int[] {virusList.get(i).x, virusList.get(i).y});
                visitedVirus[virusList.get(i).x][virusList.get(i).y] = true;
            }
        }

        while (!q.isEmpty()) {
            for(int i = 0, size = q.size(); i < size; i++) {
                int[] now = q.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || visitedVirus[nx][ny] || map[nx][ny] == 1) continue;
                    if(map[nx][ny] == 0) wallCnt--;

                    visitedVirus[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
            time++;
            if(time >= result) {
                return;
            }
            if(wallCnt <= 0) {
                result = time;
            }
        }
    }
}