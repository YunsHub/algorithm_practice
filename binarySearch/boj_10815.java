import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815 {
    static int N, M;
    static int[] arr;


    // 이분탐색 활용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(binarySearch(num)){
                sb.append("1").append(" ");
            } else {
                sb.append("0").append(" ");
            }
        }

        System.out.println(sb);
    }

    public static boolean binarySearch(int num) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midNum = arr[mid];

            if(num < midNum) {
                right = mid - 1;
            } else if (num > midNum) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
