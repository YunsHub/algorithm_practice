import java.util.*;
import java.io.*;

class Main
{
    static int DIR_NUM = 4;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N,M, wall, answer;
    static List<int[]> node;
    static int[][] map;
    static boolean[] visited;
    static List<int[]> virusList;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wall = 0;
        map = new int[N][M];
        node = new ArrayList<>();
        virusList = new ArrayList<>();
        answer = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) node.add(new int[] {i, j});
                else if(map[i][j] == 2) virusList.add(new int[] {i, j});
                else wall++;
            }
        }
        visited = new boolean[node.size()];
        combination(0, 0);

        System.out.println(answer);
    }

    public static int bfs() {
        int virusNum = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] virusVisited = new boolean[N][M];
        for(int[] virus : virusList) {
            q.add(virus);
            virusVisited[virus[0]][virus[1]] = true;
            virusNum++;
        }

        while(!q.isEmpty()) {
            for(int i=0, size=q.size(); i<size; i++) {
                int[] now = q.poll();
                for(int dir=0; dir<DIR_NUM; dir++) {
                    int nx = now[0] + dx[dir];
                    int ny = now[1] + dy[dir];
                    if(!isRange(nx, ny)) continue;
                    if(virusVisited[nx][ny] || map[nx][ny] == 1) continue;
                    q.add(new int[] {nx, ny});
                    virusVisited[nx][ny] = true;
                    virusNum++;
                }
            }
        }
        return N*M-virusNum-(wall+3);
    }

    public static boolean isRange(int x, int y) {
        return x>=0 && y>=0 && x<N && y<M;
    }

    public static void combination(int idx, int cnt) {
        if(cnt == 3) {
            answer = Math.max(answer, bfs());
            return;
        }

        for(int i=idx; i<node.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                int[] now = node.get(i);
                map[now[0]][now[1]] = 1;
                combination(i+1, cnt+1);
                map[now[0]][now[1]] = 0;
                visited[i] = false;
            }
        }
    }
}

/*

7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

27
*/