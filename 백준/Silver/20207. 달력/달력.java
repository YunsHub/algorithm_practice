import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;
    static int[] calendar;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        calendar = new int[367];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sd = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            for (int j = sd; j <= ed; j++) {
                calendar[j]++;
            }
        }

        boolean check;
        int column = 0;
        int row = 0;
        for(int i = 1; i <= 366; i++) {
            if(calendar[i] != 0) {
                check = true;
            } else {
                check = false;
                result += column * row;
                row = 0;
                column = 0;
            }
            if(check) {
                column++;
                row = Math.max(row, calendar[i]);
            }
        }
        System.out.println(result);
    }

}