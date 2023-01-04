import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int res = bfs();
        System.out.println((res == -1) ? "use the stairs" : res);
    }

    public static int bfs(){
        int result = -1;
        Queue<Integer> q = new LinkedList();//층
        boolean[] visited = new boolean[F+1];

        q.add(S);

        while(!q.isEmpty()){
            result++;
            for(int i=0, size = q.size(); i<size; i++){
                int next = q.poll();
                if(next == G){
                    return result;
                }

                int up = next + U;
                if(up <= F && !visited[up]){
                    visited[up] = true;
                    q.add(up);
                }
                int down = next - D;
                if(down > 0 && !visited[down]){
                    visited[down] = true;
                    q.add(down);
                }

            }
        }
        return -1;
    }

}