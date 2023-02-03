import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        boolean[][] arr = new boolean[N + 1][N + 1];
        int[] result = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            arr[i][i] = true;
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = true;
        }
        
        for(int k = 1; k <= N; k++) { //경유지
            for(int i = 1; i <= N; i++) {   //시작점
                for(int j = 1; j <= N; j++){    // 끝점
                    if(arr[i][j]) {
                        continue;
                    }
                    if(arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                // if(i == j) continue;
                if(arr[i][j]) {
                    result[i]++;
                    result[j]++;
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            if(result[i] == N + 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}