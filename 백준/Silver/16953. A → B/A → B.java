import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[1_000_000_001];

        System.out.println(bfs(A) + 1);

    }

    public static int bfs(long start) {
        Queue<Long> q = new LinkedList<>();
        int result = 0;
        q.add(start);

        while (!q.isEmpty()) {
            for(int i = 0, size = q.size(); i < size; i++) {
                long now = q.poll();
                if(now < 1_000_000_001 && !visited[(int) now]) {
                    if(now == B) {
                        return result;
                    }
                    visited[(int)now] = true;
                    q.add(now * 10 + 1);
                    q.add(now * 2);
                }
            }
            result++;
        }
        return -2;
    }
}