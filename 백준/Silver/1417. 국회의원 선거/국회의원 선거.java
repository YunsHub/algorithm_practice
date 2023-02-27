import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2- o1);

        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < N - 1; i++) {
            int cnt = Integer.parseInt(br.readLine());
            pq.add(cnt);
        }

        while (!pq.isEmpty()) {
            int compare = pq.poll();
            if(dasom > compare) {
                break;
            }
            pq.add(--compare);
            dasom++;
            result++;
        }
        System.out.println(result);

    }
}