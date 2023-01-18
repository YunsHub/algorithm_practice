import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static ArrayList<int[]>[] list;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            list[p].add(new int[] {q, r});
            list[q].add(new int[] {p, r});
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            count = 0;
            bfs(k, v);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int k, int v) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N + 1];
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0, size = list[now].size(); i < size; i++) {
                if(!visited[list[now].get(i)[0]] && list[now].get(i)[1] >= k) {
                    count++;
                    q.add(list[now].get(i)[0]);
                    visited[list[now].get(i)[0]] = true;
                }
            }

        }
    }
}