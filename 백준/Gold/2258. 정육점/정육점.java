import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            arr[i] = new int[] {weight, price};
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(Integer.compare(o1[1], o2[1]) == 0) {
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int totalGram = 0;
        int totalPrice = 0;
        int result = Integer.MAX_VALUE;
        boolean possible = false;
        for(int i = 0; i< N; i++) {
            totalGram += arr[i][0];

            if(i > 0 && arr[i - 1][1] == arr[i][1]) {
                totalPrice += arr[i][1];
            } else{
                totalPrice = arr[i][1];
            }

            if(totalGram >= M) {
                possible = true;
                result = Math.min(result, totalPrice);
            }
        }
        if(possible) {
            System.out.println(result);
        } else{
            System.out.println(-1);
        }

    }
}