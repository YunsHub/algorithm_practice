import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        String num = "666";
        while (true) {
            if(num.contains("666")){
                cnt++;
            }

            if(N == cnt) {
                System.out.println(num);
                break;
            }

            int a = Integer.parseInt(num);
            a++;
            num = String.valueOf(a);


        }
    }
}