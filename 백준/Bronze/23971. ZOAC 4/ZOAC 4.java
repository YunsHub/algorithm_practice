import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result1 = 0;
        int result2 = 0;
        for(int i = 0; i < H; i+= 1 + N) {
            result1++;
        }
        for(int j = 0; j < W; j+= 1 + M) {
            result2++;
        }
        System.out.println(result1 * result2);

    }
}