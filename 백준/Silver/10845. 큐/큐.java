import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            switch(S) {
                case "push" :
                    last = Integer.parseInt(st.nextToken());
                    q.offer(last);
                    break;
                case "pop" :
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(q.size()).append("\n");
                    break;
                case "empty" :
                    if(q.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front" :
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.peek()).append("\n");
                    break;
                case "back" :
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(last).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}