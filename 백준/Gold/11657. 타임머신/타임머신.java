import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
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
//    static Edge[] arr;
    static ArrayList<Edge> arr;
    static long[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
//        arr = new Edge[M + 1];
        arr = new ArrayList<>();
        distance = new long[N + 1];
        Arrays.fill(distance, INF);

        int[][] test = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(test[i], 999_999_999);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            test[A][B] = Math.min(test[A][B], C);
//            arr[i] = new Edge(A, B, C);
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(test[i][j] < 999_999_999){
                    arr.add(new Edge(i, j, test[i][j]));
                }
            }
        }

        BellmanFord(1);

        StringBuilder sb = new StringBuilder();
//        System.out.println(Arrays.toString(distance));
        for (int i = 2; i <= N; i++) {
            if (distance[i] >= INF) {
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
            for (int j = 0, size = arr.size(); j < size; j++) {
                Edge edge = arr.get(j);
                if (distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.cost) {
                    distance[edge.end] = distance[edge.start] + edge.cost;
                }
            }
        }

        for(int i = 0, size = arr.size(); i < size; i++) {
            Edge edge = arr.get(i);

            if (distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.cost) {
                System.out.println("-1");
                System.exit(0);
            }
        }

    }

}