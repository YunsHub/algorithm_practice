import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1946 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int list[] = new int[N+1];

            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                list[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int result = 1;
            int min = list[1];
            for(int j=2; j<=N; j++){
                if(list[j] < min){
                    result++;
                    min = list[j];
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }
}
