import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static int result;
    static int[] visited;
    static boolean check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new int[F + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        result = Integer.MAX_VALUE;

        dfs(S, 0);

        if(check) {
            System.out.println(result);
        } else{
            System.out.println("use the stairs");
        }

    }

    public static void dfs(int now, int count) {
        if(now == G) {
            result = Math.min(result, count);
            check = true;
            return;
        }
        if(visited[now] <= count) {
            return;
        }

        visited[now] = count;
        if(now + U <= F){
            dfs(now + U, count + 1);
        }
        if(now - D > 0) {
            dfs(now - D, count + 1);
        }

    }

}