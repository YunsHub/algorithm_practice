import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        int width = Integer.MAX_VALUE;
        int dis1 = num[1] - num[0];
        for(int i = 1; i < N - 1; i++) {
            int dis2 = num[i + 1] - num[i];
            width = Math.min(gcd(dis1, dis2), width);
            dis1 = dis2;
        }
        System.out.println((num[N - 1] - num[0]) / width - (N - 1));

    }
    public static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}