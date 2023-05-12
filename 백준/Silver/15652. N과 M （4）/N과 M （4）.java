import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[M];
        permutation(0, 0);
        System.out.println(sb);
    }

    public static void permutation(int idx, int cnt) {
        if(cnt == M) {
            for(int n : num) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = idx; i < N; i++) {
            num[cnt] = i + 1;
            permutation(i, cnt + 1);
        }
    }
}