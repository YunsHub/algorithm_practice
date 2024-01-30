import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        long sum = 0;
        int start = 1, end = 1;
        
        while(end <= N + 1) {
            if(sum == N) answer++;
            
            if(sum < N) {
                sum += end++;                
            } else {
                sum -= start++;
            }
        }
        
        System.out.println(answer);
    }
}
    