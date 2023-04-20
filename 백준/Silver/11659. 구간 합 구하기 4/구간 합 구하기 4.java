import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N + 1];
        int[] dp = new int[N + 1];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum += num[i];
            dp[i] += sum;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[end] - dp[start - 1]).append("\n");
        }
        System.out.println(sb);
    }
}