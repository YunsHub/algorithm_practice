import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) triangle[i][j] += triangle[i-1][j];
                else triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            answer = Math.max(answer, triangle[N-1][i]);
        }

        System.out.println(answer);
    }
}