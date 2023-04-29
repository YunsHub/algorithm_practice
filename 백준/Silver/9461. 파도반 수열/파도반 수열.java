import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long dp[] = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i < 101; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}