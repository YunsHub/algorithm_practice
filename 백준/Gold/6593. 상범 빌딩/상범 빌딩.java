import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C;
    static char[][][] arr;
    static int dx[] = {0, 0, 0, 0, 1, -1};
    static int dy[] = {0, -1, 0, 1, 0, 0};
    static int dz[] = {1, 0, -1, 0, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L == 0) {
                break;
            }

            arr = new char[L][R][C];

            int sx = 0 , sy = 0, sz = 0;
            for(int i = 0; i < L; i++) {
                for(int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for(int k = 0; k < C; k++) {
                        arr[i][j][k] = str.charAt(k);
                        if(arr[i][j][k] == 'S') {
                            sx = i;
                            sy = j;
                            sz = k;
                        }
                    }
                }
                br.readLine();
            }
            int res = bfs(sx, sy, sz);
            sb.append((res == -1) ? "Trapped!\n" : "Escaped in " + res + " minute(s).\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int x, int y, int z) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y, z});
        arr[x][y][z] = '#';

        while (!q.isEmpty()) {
            result++;
            for(int i = 0, size = q.size(); i < size; i++) {
                int[] now = q.poll();
                for(int j = 0; j < 6; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    int nz = now[2] + dz[j];

                    if(nx < 0 || nx >= L || ny < 0 || ny >= R || nz < 0 || nz >= C) {continue;}
                    if(arr[nx][ny][nz] == '#') {continue;}
                    else if(arr[nx][ny][nz] == '.'){
                        arr[nx][ny][nz] = '#';
                        q.add(new int[]{nx, ny, nz});
                    }
                    else{
                        return result;
                    }

                }
            }
        }
        return -1;
    }
}
