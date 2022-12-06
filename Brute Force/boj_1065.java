import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1065 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 1이상 100미만은 다 한수처리 (예제 1입력 = 99 인걸 보면 알 수 있음)
        int count = 0;
        if(N < 100){
            count = N;
        } else {
            count = 99;
            int i = 100;
            while(i <= N){
                int one = i / 100;
                int two = (i % 100) / 10;
                int three = (i % 100) % 10;
                if((three - two) == (two - one)){
                    count++;
                }
                i++;
            }
        }

        System.out.println(count);
    }
}
