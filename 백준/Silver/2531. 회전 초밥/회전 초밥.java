import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] dish = new int[N];
        int[] sushi = new int[D + 1];
        int result = 0;
        int max = 0;

        for(int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(br.readLine());
            if(i < K) {
                if(sushi[dish[i]] == 0) {
                    max++;
                }
                sushi[dish[i]]++;
            }
        }
        result = max;
        for(int i = 0; i < N; i++) {
            int prev = dish[i];
            int next = dish[(i + K) % N];
            if(sushi[prev] == 1) {
                max--;
            }
            sushi[prev]--;

            if(sushi[next] == 0) {
                max++;
            }
            sushi[next]++;
            if(result <= max) {
                result = max;
                if(sushi[C] == 0) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}