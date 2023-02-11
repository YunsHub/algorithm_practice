import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int S, T, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= test; test_case++) {
            String[] input = br.readLine().split(" ");
            S = Integer.parseInt(input[0]);
            T = Integer.parseInt(input[1]);
            cnt = 0;

            bfs();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {S, T});

        while (!q.isEmpty()) {
            for(int i = 0, size = q.size(); i < size; i++) {
                int[] now = q.poll();
                if(now[0] > now[1]) {
                    continue;
                }
                if(now[0] == now[1]) {
                    return;
                }
                q.add(new int[] {now[0] * 2 , now[1] + 3});
                q.add(new int[] {now[0] + 1, now[1]});
            }
            cnt++;
        }
    }
}