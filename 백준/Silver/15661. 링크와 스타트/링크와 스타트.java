import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k = 1; k < N; k ++) {
            comb(0, 0, k);
        }
        //comb(0, 0);
        System.out.println(result);
    }

    public static void comb(int idx, int cnt, int k) {
        if (cnt == k) {
            diff();
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(i + 1, cnt + 1, k);
                visited[i] = false;
            }
        }
    }

    public static void diff() {
        int start_team = 0;
        int link_team = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(visited[i] != visited[j]) {
                    continue;
                }
                if (visited[i] && visited[j]) {
                    start_team += arr[i][j];
                    start_team += arr[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    link_team += arr[i][j];
                    link_team += arr[j][i];
                }
            }
        }


        result = Math.min(result, Math.abs(start_team - link_team));
        if(result == 0) {
            System.out.println("0");
            System.exit(0);
        }
    }
}