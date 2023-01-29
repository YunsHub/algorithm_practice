import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for(int j = 0; j < M; j++) {
            String name = br.readLine();
            if(set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int i = 0, size = list.size(); i < size; i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);

    }
}