import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603 {
    static int K;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }

            arr = new int[K];
            visited = new boolean[K];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void comb(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            comb(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}
