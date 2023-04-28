import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(recur(N, 0));
    }

    public static int recur(int n, int cnt) {
        if(n <= 1) {
            return cnt;
        }
        return Math.min(recur(n / 2, cnt + 1 + (n % 2)), recur(n / 3, cnt + 1 + (n % 3)));
    }
}