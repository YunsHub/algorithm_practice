import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        int[] vip = new int[M + 2];
        vip[0] = 0;
        vip[M + 1] = N + 1;
        for(int i = 1; i <= M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }


        int result = 1;
        if(M == 0) {
            result = dp[N];
        } else {
            for(int i = 0; i < M + 1; i++) {
                result *= dp[vip[i + 1] - vip[i] - 1];
            }
        }
        // 0 4 7 10

        System.out.println(result);
    }
}