import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, A, B;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs(N));
    }

    // +1 , -1, +A, +B, -A, -B, *A, *B,
    public static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        arr = new int[100_001];
        boolean[] visited = new boolean[100_001];
        q.add(new int[] {start, start});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int s = now[0];
            int p = now[1];

            if(s == M) {
                return arr[p];
            }

            if(s >= 0 && s <= 100_000 && !visited[s]) {
                arr[s] = arr[p] + 1;
                visited[s] = true;
                q.add(new int[] {s + 1, s});
                q.add(new int[] {s - 1, s});
                q.add(new int[] {s + A, s});
                q.add(new int[] {s + B, s});
                q.add(new int[] {s - A, s});
                q.add(new int[] {s - B, s});
                q.add(new int[] {s * A, s});
                q.add(new int[] {s * B, s});
            }

        }
        return -1;
    }
}