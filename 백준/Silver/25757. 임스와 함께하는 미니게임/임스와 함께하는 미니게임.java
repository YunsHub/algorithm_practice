import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }
        switch (game) {
            case "Y": {
                System.out.println(set.size());
                break;
            }
            case "F": {
                System.out.println(set.size() / 2);
                break;
            }
            case "O": {
                System.out.println(set.size() / 3);
                break;
            }
        }

    }
}