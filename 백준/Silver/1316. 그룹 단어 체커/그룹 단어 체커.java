import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        while (N-- > 0) {
            String str = br.readLine();
            boolean[] alphabet = new boolean[27];
            boolean check = true;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(i > 0 && str.charAt(i - 1) == str.charAt(i)) {
                    continue;
                }
                if(!alphabet[c - 'a']) {
                    alphabet[c - 'a'] = true;
                } else {
                    check = false;
                }
            }
            if(check) {
                result++;
            }
        }
        System.out.println(result);
    }
}