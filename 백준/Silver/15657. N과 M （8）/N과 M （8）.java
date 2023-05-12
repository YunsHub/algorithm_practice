import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] num, result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        permutation(0, 0);
        System.out.println(sb);

    }

    public static void permutation(int idx, int cnt) {
        if (cnt == M) {
            for (int n : result) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < N; i++) {
            result[cnt] = num[i];
            permutation(i, cnt + 1);
        }
    }
}