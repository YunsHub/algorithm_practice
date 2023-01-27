import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] isExist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        isExist = new boolean[50000];
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        comb(0, 0, 0);
        for(int i=1; i<50000; i++){
            if(!isExist[i]){
                if(i%2==0){
                    System.out.println("holsoon win at " + i);
                }
                else{
                    System.out.println("jjaksoon win at " + i);
                }
                break;
            }
        }

    }

    public static void comb(int idx, int cnt, int sum) {
        isExist[sum] = true;
        if(cnt == K) {
            return;
        }

        for(int i = idx; i < N; i++) {
            comb(i, cnt + 1, sum + arr[i]);
        }

    }
}