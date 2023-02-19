import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, min;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0 , -1, 0};
    static int[] dy = {0, 0, -1 , 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        dfs(N+1, 0, 0);
        //dfs
        System.out.println(min);


    }

    public static void dfs(int pos, int sum, int cnt) {
        if(min < sum){
            return;
        }
        if(cnt == 3){
            min = sum;
            return;
        }
        if(pos > N*N-N){
            return;
        }

        //선택안했을 때
        dfs(pos + 1, sum, cnt);

        //선택 가능하면 선택해보기
        int x = pos/N;
        int y = pos%N;
        //5방향이 다 빈칸인지 확인
        boolean possible = true;
        for(int i = 0; i < 5; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]){
                possible = false;
                break;
            }
        }

        if(possible){
            int result = 0;
            //방문체크
            for(int i = 0; i < 5; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                visited[nx][ny] = true;
                result += arr[nx][ny];
            }
            dfs(pos + 1, sum + result, cnt + 1);
            //해제
            for(int i = 0; i < 5; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                visited[nx][ny] = false;
            }
        }

    }
}