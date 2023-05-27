import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] hp = new int[N + 1];
        int[] happy = new int[N + 1];
        int life = 100;
        int[][] dp = new int[N + 1][life];
        for(int i = 1; i <= N; i++) {
            hp[i] = Integer.parseInt(st1.nextToken());
            happy[i] = Integer.parseInt(st2.nextToken());
        }

        // 선택할 때, 선택 안할 때
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < life; j++) {
                if(j >= hp[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - hp[i]] + happy[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][life - 1]);

    }
}