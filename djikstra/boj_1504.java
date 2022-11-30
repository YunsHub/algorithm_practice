import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1504 {
    static int N;
    static int E;
    static ArrayList<Vertex>[] graph;

    static int v1;
    static int v2;

    static int result;

    static class Vertex implements Comparable<Vertex> {
        int v;
        int c;

        Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.v - o.v;
        }

    }

    static int djikstra(int start, int end) {
        int[] d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        d[start] = 0; // 시작지점 0으로 초기화

        // 시작점과 연결된 모든 간선에 대한 정보 추가
        for (int i = 0; i < graph[start].size(); i++) {
            Vertex vertex = graph[start].get(i); // 시작점에서 갈 수 있는 정점

            d[vertex.v] = vertex.c;
            pq.add(new Vertex(vertex.v, vertex.c));
        }

        while (!pq.isEmpty()) {
            Vertex vertex = pq.poll(); // 현재 정점

            if (d[vertex.v] < vertex.c)
                continue;

            for (int i = 0; i < graph[vertex.v].size(); i++) {
                Vertex nextVertex = graph[vertex.v].get(i); // 현재 정점에서 갈 수 있는 정점

                // 지금까지 계산한 다음 정점까지 갈 수 있는 거리보다 현재 정점에서 가는 것이 더 짧다면
                if (d[nextVertex.v] > d[vertex.v] + nextVertex.c) {
                    d[nextVertex.v] = d[vertex.v] + nextVertex.c;
                    pq.add(new Vertex(nextVertex.v, d[nextVertex.v]));
                }
            }
        }

        return d[end];
    }

    static int getResult(int v1, int v2) {
        int d = 0;

        int d1 = djikstra(1, v1);
        if (d1 == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        d += d1;

        int d2 = djikstra(v1, v2);
        if (d2 == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        d += d2;

        int d3 = djikstra(v2, N);
        if (d3 == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        d += d3;

        return d;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 방향성 없는 그래프이니 양 쪽 정점에 모두 추가
            graph[v1].add(new Vertex(v2, c));
            graph[v2].add(new Vertex(v1, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야할 정점1
        v2 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야할 정점2

        int d1 = getResult(v1, v2); // 1 -> v1 -> v2 -> N
        int d2 = getResult(v2, v1); // 1 -> v2 -> v1 -> N

        if (d1 == Integer.MAX_VALUE && d2 == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.println(Math.min(d1, d2));

        br.close();
    }

}