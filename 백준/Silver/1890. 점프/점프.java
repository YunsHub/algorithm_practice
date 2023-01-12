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
        dp[0][0] = 1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(dp[N-1][N-1]);
    }

    public static void solve() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0){ continue;}
                int right = j + map[i][j];
                int down = i + map[i][j];

                if(right < N){
                    dp[i][right] += dp[i][j];
                }
                if(down < N){
                    dp[down][j] += dp[i][j];
                }
            }
        }
    }
}