import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int N, M;
    static final long INF = Long.MAX_VALUE;
    static Edge[] arr;
    static long[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Edge[M];
        distance = new long[N + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arr[i] = new Edge(A, B, C);
        }

        BellmanFord(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (distance[i] == INF) {
                sb.append("-1\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void BellmanFord(int start) {
        distance[start] = 0;

        for (int i = 0; i < N; i++) {
            for (Edge edge : arr) {
                if (distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.cost) {
                    distance[edge.end] = distance[edge.start] + edge.cost;
                }
            }
        }

        for(Edge edge : arr) {
            if (distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.cost) {
                System.out.println("-1");
                System.exit(0);
            }
        }

    }

}