import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = 10001;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++){
            Arrays.fill(arr[i], INF);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            arr[start][end] = arr[end][start] = 1;
        }

        for(int k = 0; k < N; k++){ // 경유지
            for(int i = 0; i < N; i++){ // 시작점
                if(i==k){continue;}
                for(int j = 0; j < N; j++){ // 끝점
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int result = 0;
        int min = INF;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = 0; j < N; j++){
                sum += arr[i][j];
            }
            if(sum < min) {
                min = sum;
                result = i;
            }
        }

        System.out.println(result+1);
    }
}