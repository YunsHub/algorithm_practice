import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h, result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static Queue<int[]> q;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            q = new LinkedList<>();
            result = 0;

            int x = 0, y = 0;

            for(int i = 0; i < h; i++) {
                String str = br.readLine();
                for(int j = 0; j < w; j++) {
                    arr[i][j] = str.charAt(j);
                    if(arr[i][j] == '*'){
                        q.add(new int[]{i, j});
                    }
                    else if(arr[i][j] == '@'){
                        x = i;
                        y = j;
                    }
                }
            }
            q.add(new int[]{x, y});
            sb.append(simulation() ? result : "IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static boolean simulation() {
        while(!q.isEmpty()){
            result++;
            for(int i=0, size = q.size(); i<size; i++){
                int[] now = q.poll();
                for(int j=0; j<4; j++){
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w){
                        if(arr[now[0]][now[1]] == '@'){
                            return true;
                        }
                        continue;
                    }
                    if(arr[nx][ny] != '.'){continue;}
                    arr[nx][ny] = arr[now[0]][now[1]];
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}