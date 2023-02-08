import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i = 4; i < 11; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }
            System.out.println(dp[N]);
        }

    }



}