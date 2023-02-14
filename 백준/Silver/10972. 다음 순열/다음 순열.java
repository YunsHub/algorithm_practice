import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        nextPermutation();

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    static void nextPermutation() {
        int a = arr.length - 1;
        int b = arr.length - 1;

        while (a > 0 && arr[a - 1] >= arr[a]) {
            a--;
        }

        if(a == 0) {
            System.out.println(-1);
            System.exit(0);
        }

        while (arr[a - 1] >= arr[b]) {
            b--;
        }

        swap(a - 1, b);

        b = arr.length - 1;
        while (a < b) {
            swap(a, b);
            a += 1;
            b -= 1;
        }
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}