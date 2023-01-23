import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min, max;
    static int[] arr, operation;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operation = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operation[i] = Integer.parseInt(st.nextToken());
        }

        calculator(1, arr[0], operation[0], operation[1], operation[2], operation[3]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void calculator(int idx, int num, int plus, int minus, int mul, int div){
        if(idx == N){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        if(plus > 0){
            calculator(idx + 1, num + arr[idx], plus -1, minus, mul, div);
        }
        if(minus > 0){
            calculator(idx + 1, num - arr[idx], plus, minus-1, mul, div);
        }
        if(mul > 0){
            calculator(idx + 1, num * arr[idx], plus, minus, mul - 1, div);
        }
        if(div > 0){
            calculator(idx + 1, num / arr[idx], plus, minus, mul, div - 1);
        }
    }

}