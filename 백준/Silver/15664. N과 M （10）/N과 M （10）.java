import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        result = new int[M];
        visited = new boolean[N];
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
            for(int n : result) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = idx; i < N; i++) {
            if (!visited[i] && before != num[i]) {
                visited[i] = true;
                result[cnt] = num[i];
                before = num[i];
                permutation(i + 1,cnt + 1);
                visited[i] = false;
            }
        }
    }
}