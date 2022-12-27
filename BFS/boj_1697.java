import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {
    static int N, K;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        visited = new boolean[100001];

        bfs(N);

        System.out.println(arr[K]);
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        arr[x] = 0;
        visited[x] = true;
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n == K) {
                return;
            }
            if (n - 1 >= 0 && !visited[n - 1]) {
                arr[n - 1] = arr[n] + 1;
                visited[n - 1] = true;
                q.add(n - 1);
            }
            if (n + 1 <= 100000 && !visited[n + 1]) {
                arr[n + 1] = arr[n] + 1;
                visited[n + 1] = true;
                q.add(n + 1);
            }
            if (n * 2 <= 100000 && !visited[n * 2]) {
                arr[n * 2] = arr[n] + 1;
                visited[n * 2] = true;
                q.add(n * 2);
            }
        }
    }
}
