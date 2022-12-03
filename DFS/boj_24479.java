import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_24479 {
    static int N, M, R;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] result;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        result = new int[N + 1];
        cnt = 1;

        for (int i = 1; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start].add(end);
            arr[end].add(start);
        }

        dfs(R);

        for(int i = 1; i <= N; i++){
            sb.append(result[i] + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start) {
        if(visited[start]){
            return;
        } else{
            visited[start] = true;
            result[start] = cnt++;
            Collections.sort(arr[start]);
            for(int i = 0; i < arr[start].size(); i++){
                dfs(arr[start].get(i));
            }
        }

    }
}
