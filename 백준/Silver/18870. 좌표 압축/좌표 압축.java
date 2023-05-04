import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int idx;
        int x1;
        int x2;

        public Node(int idx, int x1) {
            this.idx = idx;
            this.x1 = x1;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] node = new Node[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            node[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x1 - o2.x1;
            }
        });

        int num = 0;
        for(int i = 0; i < N; i++) {
            if(i > 0 && node[i-1].x1 != node[i].x1) {
                num++;
            }
            node[i].x2 = num;
        }
        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.idx - o2.idx;
            }
        });
        for(Node result : node) {
            sb.append(result.x2).append(" ");
        }

        System.out.println(sb);
    }
}