import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cal = st.nextToken();
            switch (cal) {
                case "add": {
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "remove": {
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "check": {
                    int num = Integer.parseInt(st.nextToken());
                    if(set.contains(num)){
                        sb.append(1).append("\n");
                    } else{
                        sb.append(0).append("\n");
                    }
                    break;
                }
                case "toggle": {
                    int num = Integer.parseInt(st.nextToken());
                    if(set.contains(num)){
                        set.remove(num);
                    } else{
                        set.add(num);
                    }
                    break;
                }
                case "all": {
                    for(int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                }
                case "empty": {
                    set.clear();
                    break;
                }
            }
        }
        System.out.println(sb);

    }
}