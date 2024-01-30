import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int K = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);

        int answer = 0;
        int start = 0, end = N-1;
        while(start < end) {
            int num = arr[start] + arr[end];
            if(num == K) {
                answer++;
                start++;
                end--;
            } else if(num < K) {
                start++;
            } else {
                end--;
            }
        }
        
        System.out.println(answer);

    }
}