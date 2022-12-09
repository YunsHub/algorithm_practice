import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18429 {
    public static int N, K, result;
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 500);

        System.out.println(result);
    }

    public static void backtracking(int idx, int strength) {
        if (idx == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i] && strength + arr[i] - K >= 500) {
                visited[i] = true;
                backtracking(idx + 1, strength + arr[i] - K);
                visited[i] = false;
            }
        }
    }
}
