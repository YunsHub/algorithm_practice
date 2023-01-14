import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
//    static int[] arr;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++) {
            int n2 = Integer.parseInt(st.nextToken());
            pq.add(n2 - n1);
            n1 = n2;
        }

        int result = 0;
        for(int i = N-K; i>0; i--){
            result += pq.poll();
        }
        System.out.println(result);
//        pq = new PriorityQueue<>((o1, o2)-> o2[0] - o1[0]);//차이 내림차순
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int gap[] = new int[N-1];
//        for(int i = 0; i < N-1; i++){
//            gap[i] = arr[i+1] -  arr[i];
//            pq.add(new int[]{gap[i], i});
//        }
//
//        for(int i = 0; i < K; i++){
//            int[] remove = pq.poll();
//            gap[remove[1]] = -1;
//        }
//
//        for(int i=0; )

    }
}