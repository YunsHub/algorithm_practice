import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class id_2609{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int least = gcd(N ,M);
        System.out.println(least);
        System.out.println((N * M) / least);

    }

    public static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a % b);

    }
}
