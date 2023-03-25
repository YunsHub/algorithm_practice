import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] people = new int[N + 1];

        int sum = 0;
        int max = -1;
        int cnt = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            if(i <= X) {
                sum += people[i];
            }
        }
//        5 2
//        1 2 1 2 1
        max = sum;
        for(int i = 1; i <= N - X; i++) {
            sum += people[i + X];
            sum -= people[i];
            if(max < sum) {
                max = sum;
                cnt = 1;
            } else if(max == sum) {
                cnt++;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}