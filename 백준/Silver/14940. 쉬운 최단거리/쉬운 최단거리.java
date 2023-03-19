import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = new int[N][M];
        int sx = 0, sy = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                result[i][j] = -1;
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    sx = i;
                    sy = j;
                }
                else if(map[i][j] == 0){
                    result[i][j] = 0;
                }
            }
        }
        bfs(sx, sy);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void bfs(int sx, int sy){
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        result[sx][sy] = 0;
        q.add(new int[]{sx, sy});

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=M || result[nx][ny] != -1) continue;

                result[nx][ny] = result[now[0]][now[1]] + 1;
                q.add(new int[]{nx, ny});

            }
        }
    }
}