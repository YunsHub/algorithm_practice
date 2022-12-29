import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj14501 {
    static int N;
    static ArrayList<Consulting> list;
    static int result;

    static class Consulting {
        int day;
        int price;

        public Consulting(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Consulting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        solve(0, 0);

        System.out.println(result);

    }

    public static void solve(int idx, int total) {
        if (idx == N) {
            result = Math.max(result, total);
            return;
        }
        if (idx > N) {
            return;
        }

        solve(idx + list.get(idx).day, total + list.get(idx).price);
        solve(idx + 1, total);
    }
}
