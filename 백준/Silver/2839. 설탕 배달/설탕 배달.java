import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while (true) {
            if(N % 5 == 0) {
                result += N / 5;
                break;
            }
            if(N < 0) {
                result = -1;
                break;
            }

            N -= 3;
            result++;
        }

        System.out.println(result);

    }
}