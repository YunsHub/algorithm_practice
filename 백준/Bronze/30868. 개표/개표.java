import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            int m = n / 5;
            int r = n % 5;
            for(int i=0;i<m;i++) {
                sb.append("++++ ");
            }
            for(int i=0;i<r;i++) {
                sb.append("|");
            }
            System.out.println(sb);
        }
    }
}
