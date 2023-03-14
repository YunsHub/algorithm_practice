import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int result = Integer.MAX_VALUE;

        int Acnt = 0;
        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == 'a') {
                Acnt++;
            }
        }


        for(int i = 0; i < len; i++) {
            int Bcnt = 0;
            for(int j = i; j < i + Acnt; j++) {
                int idx = j % len;
                if(str.charAt(idx) == 'b') {
                    Bcnt++;
                }
            }
            result = Math.min(result, Bcnt);
        }
        System.out.println(result);
    }
}