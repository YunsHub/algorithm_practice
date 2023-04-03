import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N - 1; i > 0; i--) {
            int maxIdx = i;
            for(int j = i - 1; j >= 0; j--) {
                if(num[maxIdx] < num[j]) {
                    maxIdx = j;
                }
            }

            if(maxIdx != i) {
                int temp = num[i];
                num[i] = num[maxIdx];
                num[maxIdx] = temp;
                result++;
            }
            if(result == K) {
                System.out.println(num[maxIdx] + " " + num[i]);
                System.exit(0);
            }
        }

        if(result < K) {
            System.out.println(-1);
        }


    }
}