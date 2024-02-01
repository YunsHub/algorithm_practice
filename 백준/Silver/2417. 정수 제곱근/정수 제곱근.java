import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long answer = 0;
        long start = 0, end = N;
        while(start <= end) {
            long mid = (start + end) / 2;

            if(N <= Math.pow(mid, 2)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
}