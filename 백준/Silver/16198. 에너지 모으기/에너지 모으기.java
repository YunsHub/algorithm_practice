import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> list;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        dfs(0);
        System.out.println(result);
    }
    public static void dfs(int sum) {
        if(list.size() <= 2) {
            result = Math.max(result, sum);
            return;
        }
        for(int i = 1; i < list.size() - 1; i++) {
            int num = list.get(i);
            int energy = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            dfs(sum + energy);
            list.add(i, num);
        }
    }
}