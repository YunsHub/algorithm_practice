import java.util.*;
import java.io.*;

// 1 3 6 10 15
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum[] = new int[N+1];        
        
        for(int i=1; i<=N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int start = 1, end = 2;
        int totalSum = sum[N];
        while(end <= N ) {
            int rightDistance = sum[end] - sum[start];
            int leftDistance = totalSum - rightDistance;

            if(rightDistance == leftDistance) {
                answer = rightDistance;
                break;
            }

            answer = Math.max(answer, Math.min(rightDistance, leftDistance));
            if(rightDistance <= leftDistance) {
                end++;
            } else {
                start++;
            }
        }

        System.out.println(answer);
    }
}