import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        System.out.println(fibo(N));
    }
    public static long fibo(int n) {
        if(arr[n] == -1) {
            arr[n] = fibo(n - 2) + fibo(n - 1);
        }
        return arr[n];
    }
}