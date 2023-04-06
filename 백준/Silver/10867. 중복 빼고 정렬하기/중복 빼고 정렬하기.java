import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[2001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            n += 1000;
            num[n] = true;
        }
        for(int i = 0; i < 2001; i++) {
            if(num[i]) {
                System.out.print(i - 1000 + " ");
            }
        }

    }
}