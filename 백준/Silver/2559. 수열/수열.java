import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        int sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if(i < M) {
                sum += num[i];
            }
        }
        
        int answer = sum;        
        int start = 0, end = M;
        
        while(end < N) {
            sum += num[end++];
            sum -= num[start++];
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
    }
}
    