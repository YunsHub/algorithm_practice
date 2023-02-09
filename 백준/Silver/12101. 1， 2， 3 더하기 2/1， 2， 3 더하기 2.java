import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, cnt;
    static String result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        result = "-1";

        backtracking(0);

        System.out.println(result);

    }

    public static void backtracking(int sum) {
        if(sum == N) {
            cnt++;
            if(cnt == K) {
                result = sb.substring(0, sb.length() - 1);
                return;
            }
        }
        if(sum > N) {
            return;
        }

        for(int i = 1; i <= 3; i++) {
            sb.append(i + "+");
            backtracking(sum + i);
            sb.delete(sb.length() - 2, sb.length());
        }

    }
}