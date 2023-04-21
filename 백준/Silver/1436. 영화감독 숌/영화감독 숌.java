import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        String num = "666";
        while (true) {
            for(int i = 0; i < num.length(); i++) {
                if(num.charAt(i) == '6') {
                    if(i + 2 < num.length() && num.charAt(i + 1) == '6' && num.charAt(i + 2) == '6') {
                        cnt++;
                        break;
                    }
                }
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