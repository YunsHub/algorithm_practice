import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10819 {
    static int N;
    static int[] arr, selected;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        selected = new int[N];
        result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        permutation(0, new boolean[N]);


        System.out.println(result);
    }

    public static void permutation(int count, boolean[] visited) {
        if(count == N) {
            cal();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]){continue;}
            visited[i] = true;
            selected[count] = arr[i];
            permutation(count+1, visited);
            visited[i] = false;

        }
    }

    public static void cal() {
        int sum = 0;
        for(int i = 1; i < N; i++) {
            sum +=  Math.abs(selected[i - 1] - selected[i]);
        }
        result =  Math.max(result, sum);
    }
}
