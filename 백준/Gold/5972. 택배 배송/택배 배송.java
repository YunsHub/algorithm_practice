import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Node>[] adjlist;

    static class Node implements Comparable<Node> {
        int end, cost;

        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o1){
            return this.cost - o1.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjlist = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adjlist[i] = new ArrayList<>();
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjlist[n1].add(new Node(n2, c));
            adjlist[n2].add(new Node(n1, c));
        }

        System.out.println(dijkstra());

    }

    public static int dijkstra(){
        int[] result = new int[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.end == N){
                break;
            }

            if(result[node.end] < node.cost){
                continue;
            }

            for(Node next : adjlist[node.end]){
                int temp = node.cost + next.cost;
                if(temp < result[next.end]){
                    result[next.end] = temp;
                    pq.add(new Node(next.end, temp));
                }
            }
        }
        return result[N];
    }
}