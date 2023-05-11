import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        for(int i = 0; i < N; i++) {
            num[i] = i + 1;
        }
        permutation(0);
        System.out.println(sb);

    }
    public static void permutation(int cnt) {
        if(cnt == M) {
            for(int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[cnt] = num[i];
                permutation(cnt + 1);
                visited[i] = false;
            }
        }

    }
}