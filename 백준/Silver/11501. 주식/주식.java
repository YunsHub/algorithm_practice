import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] day = new int[N];
            int max = 0;
            long result = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                day[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = N - 1; i >= 0; i--) {
                max = Math.max(max, day[i]);
                if(day[i] <= max) {
                    result += max - day[i];
                } else {
                    max = day[i];
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}