import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1010 {

    static int N, M;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new long[M+1];
            arr[0] = 1;
            N = Math.min(N, M-N);
            long result = fact(M-N+1, M)/fact(1, N);
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

    public static long fact(int start, int end) {
        long result = 1;
        for(int i=start; i<=end; i++){
            result *= i;
        }
        return result;
    }

}