import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class boj_1941 {
    static char[][] arr;
    static boolean[] visited;
    static int[] result;
    static int total;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[5][5];
        total = 0;
        visited = new boolean[25];
        result = new int[7];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        recur(0, 0, 0);

        System.out.println(total);


    }

    public static void recur(int cur, int limit, int idx) {
        if (limit > 3) {
            return;
        }
        if (cur == 7) {
            bfs();
            return;
        }

        for (int i = idx; i < 25; i++) {
            if (visited[i]) continue;

            result[cur] = i;
            visited[i] = true;

            if (check(i)) {
                recur(cur + 1, limit + 1, i + 1);
            } else {
                recur(cur + 1, limit, i + 1);
            }

            visited[i] = false;
        }

    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(result[0]);

        boolean[] visited2 = new boolean[7];
        visited2[0] = true;

        while (!queue.isEmpty()) {

            int num = queue.poll();

            int x = num / 5;
            int y = num % 5;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;

                int result_num = 5 * nx + ny;

                for (int j = 0; j < 7; j++) {
                    if (visited2[j]) continue;

                    if (result_num == result[j]) {
                        queue.add(result[j]);
                        visited2[j] = true;
                        break;
                    }
                }

            }

        }

        for (int i = 0; i < 7; i++) {
            if (!visited2[i]) return;
        }

        total++;
    }

    public static boolean check(int num) {
        int x = num / 5;
        int y = num % 5;

        if (arr[x][y] == 'Y') {
            return true;
        }

        return false;
    }
}
