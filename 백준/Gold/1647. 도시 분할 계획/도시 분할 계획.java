import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 크루스칼 (엣지 클래스를 만들어서)
    /*
    1. Edge의 cost 오름차순 정렬하기
    2. cost가 적은 Edge부터 차례대로 union & find하면서 사이클이 없으면 union하기 + 결과값에 cost 더하기
    3. 선택한 Edge의 수가 N-1개가 되면 종료
    +) 여기서는 edge 중에 최대값을 빼야하므로 N-2개 선택하면 종료하면 된다.(최소값부터 더해가니까)
     */
    public static class Edge implements Comparable<Edge>{
        int n1;
        int n2;
        int cost;

        public Edge(int n1, int n2, int cost) {
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static PriorityQueue<Edge> edges;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        edges = new PriorityQueue<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        System.out.println(kruskal());
    }

    private static int kruskal() {
        int result = 0, cnt = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if(union(edge.n1, edge.n2)) {
                result += edge.cost;
                if(++cnt == N-2){
                    break;
                }
            }

        }
        return result;
    }

    private static boolean union(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);
        if(n1 == n2) return false;
        parent[n1] = n2;
        return true;
    }

    private static int find(int n1) {
        if(parent[n1] == 0){
            return n1;
        }
        return parent[n1] = find(parent[n1]);
    }
}