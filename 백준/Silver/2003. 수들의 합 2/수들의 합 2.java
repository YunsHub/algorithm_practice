import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int result = 0;

        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 (길이가 가변)
        int left = 0;
        int right = 0;

        while(true) {
            if(sum >= M) {
                sum -= num[left++];
            } else if (right >= N) {
                break;
            } else {
                sum += num[right++];
            }

            if(sum == M) {
                result++;
            }

        }

        System.out.println(result);


    }
}