import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static String result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        result = "Hing";

        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int x, int y) {
        if(arr[x][y] == -1) {
            result = "HaruHaru";
            return;
        }

        int nx = x + arr[x][y];
        int ny = y + arr[x][y];

        if(nx < N && !visited[nx][y]) {
            visited[nx][y] = true;
            dfs(nx, y);
        }
        if(ny < N && !visited[x][ny]) {
            visited[x][ny] = true;
            dfs(x, ny);
        }


    }
}