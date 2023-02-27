import org.omg.PortableServer.POAPackage.InvalidPolicy;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        result = new int[N];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        permutation(0);
        System.out.println(sb);
    }
    public static void permutation(int cnt) {
        if(cnt == N) {
            for(int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[cnt] = arr[i];
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }
}