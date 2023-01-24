import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];


        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        solve();

        System.out.println(dp[N]);
    }

    public static void solve() {
        for(int i = 1; i <= N; i++) {
            dp[i] = arr[i];
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + arr[i - j]);
            }
        }
    }
}