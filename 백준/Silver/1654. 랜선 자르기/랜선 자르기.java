import java.util.*;
import java.io.*;

// 10 15 17 20
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] line = new int[N];
        long min = 0, max = 0;
        for(int i=0; i<N; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if(max < line[i]) max = line[i];
        }
        max++;
        while(min < max) {
            long mid = (min + max) / 2;
            
            long cnt = 0;
            for(int i=0; i<N; i++) {
                cnt +=  (line[i] / mid);
            }

            if(cnt < K) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        
        System.out.println(min-1);
    }
}