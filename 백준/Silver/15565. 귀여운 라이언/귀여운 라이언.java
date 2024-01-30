import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] doll = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            doll[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int cnt = doll[0] == 1 ? 1 : 0;
        int start=0, end=0;
        while(end < N) {
            if(cnt == K) {
                answer = Math.min(answer, end - start + 1);
            }
            
            if(cnt < K) {
                end++;
                if(end < N && doll[end]==1) cnt++;
            } else {
                if(doll[start] == 1) cnt--;
                start++;                
            }
        }

        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
        
    }
}
    