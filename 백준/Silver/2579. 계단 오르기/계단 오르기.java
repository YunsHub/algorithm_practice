import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[N + 1];
        dp[1] = map[1];
        if (N >= 2) {
            dp[2] = map[1] + map[2];    
        }
        

        for(int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + map[i - 1], dp[i - 2]) + map[i];
        }
        System.out.println(dp[N]);

    }
}