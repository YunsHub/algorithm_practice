import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        int Astart = 0, Bstart = 0;

        while(Astart < N || Bstart < M) {
            int num = 0;
            if(Astart == N) {
                num = B[Bstart++];
            } else if(Bstart == M) {
                num = A[Astart++];
            } else if(A[Astart] < B[Bstart]) {
                num = A[Astart++];
            } else {
                num = B[Bstart++];
            }
            
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());

    }
}