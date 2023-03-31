import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(num);
        int left = 0;
        int right = N - 1;
        int result = 0;
        while (true) {
            int sum = num[left] + num[right];
            if(left >= right) {
                break;
            } else if(sum > x) {
                right--;
            } else if(sum < x) {
                left++;
            } else {
                result++;
                left++;
                right--;
            }
        }
        System.out.println(result);


    }
}