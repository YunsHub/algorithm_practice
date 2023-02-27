import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    static int N, K;
    static int[] arr;
    static int[] select;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        select = new int[K];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());;
        }
        backtracking(0);
        System.out.println(set.size());
    }
    public static void backtracking(int cnt) {
        if(cnt == K) {
            String result = "";
            for(int i = 0; i < K; i++) {
                String str = Integer.toString(select[i]);
                result += str;
            }
            set.add(Integer.parseInt(result));
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                select[cnt] = arr[i];
                backtracking(cnt + 1);
                visited[i] = false;
            }
        }
    }
}