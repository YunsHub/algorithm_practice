import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        dp[N - 1][N - 1] = 1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0);
        System.out.println(dp[0][0]);
    }

    public static void solve(int x, int y) {
        if((x != N - 1 || y != N - 1) && map[x][y] == 0){
            return;
        }

        int nx = x + map[x][y];
        int ny = y + map[x][y];
        long sum = 0;

        if(nx < N) {
            if(dp[nx][y] == 0)
                solve(nx, y);
            sum += dp[nx][y];
        }

        if(ny < N) {
            if(dp[x][ny] == 0)
                solve(x, ny);
            sum += dp[x][ny];
        }
        dp[x][y] = sum;
    }
}