import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] log = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                log[i] = i / 3;
            }

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                log[i] = i / 2;
            }

            if (i - 1 > 0 && dp[i] > dp[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
                log[i] = i - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N]).append("\n");
        while (N != 0) {
            sb.append(N).append(" ");
            N = log[N];
        }
        System.out.println(sb.toString());
    }
}