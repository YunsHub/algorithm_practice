import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Node n) {
            return x - n.x;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int maxHeight = 0;
        int maxWidth = 0;
        ArrayList<Node> list = new ArrayList<>();

        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
            if(maxHeight < y) {
                maxWidth = x;
                maxHeight = y;
            }
        }

        Collections.sort(list);

        int sum = maxHeight;
        int i = 0;
        int prevY = 0;
        int prevX = 0;
        while (i < list.size()) {
            Node node = list.get(i);
            if(node.x > maxWidth) break;
            if(node.y >= prevY) {
                sum += (node.x - prevX) * prevY;
                prevY = node.y;
                prevX = node.x;
            }
            i++;
        }

        int j = list.size() - 1;
        int nextX = list.get(j).x;
        int nextY = list.get(j).y;
        while (j > 0) {
            Node node = list.get(j - 1);
            if(node.x < maxWidth) break;
            if(node.y >= nextY) {
                sum += (nextX - node.x) * nextY;
                nextY = node.y;
                nextX = node.x;
            }
            j--;
        }
        System.out.println(sum);
    }
}