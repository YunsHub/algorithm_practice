import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        int dis = 0;
        int check = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y);
            if(i >= 1) {
                dis += distance(arr[i - 1].x, arr[i - 1].y, arr[i].x, arr[i].y);
            }
        }


        for(int i = 1; i < N - 1; i++) {
            check = dis -
                    distance(arr[i - 1].x, arr[i - 1].y, arr[i].x, arr[i].y) -
                    distance(arr[i].x, arr[i].y, arr[i + 1].x, arr[i + 1].y) + distance(arr[i - 1].x, arr[i - 1].y, arr[i + 1].x, arr[i + 1].y);
            result = Math.min(result, check);
        }

        System.out.println(result);

    }

    public static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}