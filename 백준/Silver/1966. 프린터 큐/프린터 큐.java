import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new LinkedList<>();
            int[] arr = new int[10];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                arr[n]++;
                q.add(new int[] {n, i});
            }

            int cnt = 0;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                boolean result = true;
                for(int i = now[0] + 1; i < 10; i++) {
                    if(arr[i] > 0) {
                        q.add(now);
                        result = false;
                        break;
                    }
                }
                if(result) {
                    cnt++;
                    arr[now[0]]--;
                    if(now[1] == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}