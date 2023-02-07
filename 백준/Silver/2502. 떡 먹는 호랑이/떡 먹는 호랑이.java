import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int D, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[D];
        int a = 0;
        int b = 0;

        fibo(D - 1);
        for (int i = 1; i < K; i++) {
            if ((K - arr[D - 2] * i) % arr[D - 1] == 0) {
                a = i;
                b = (K - arr[D - 2] * i) / arr[D - 1];
                break;
            }
        }
        System.out.println(a);
        System.out.println(b);
    }

    static int fibo(int n) {
        if (n <= 1) {
            arr[n] = n;
            return arr[n];
        }
        arr[n] = fibo(n - 1) + fibo(n - 2);
        return arr[n];
    }
}