import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Medal implements Comparable<Medal>{
        int world;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Medal(int world, int gold, int silver, int bronze){
            this.world = world;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Medal m) {
            if(this.gold == m.gold) {
                if(this.silver == m.silver) {
                    return this.bronze - m.bronze;
                }
                return this.silver - m.silver;
            }
            return this.gold - m.gold;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Medal> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int world = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            pq.add(new Medal(world, gold, silver, bronze));
        }

        int result = 1;
        int g = -1;
        int s = -1;
        int b = -1;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Medal medal = pq.poll();

            if(g == medal.gold && s == medal.silver && b == medal.bronze) {
                result--;
                cnt++;
            } else {
                result += cnt;
                cnt = 0;
            }

            if(K == medal.world) {
                break;
            }

            g = medal.gold;
            s= medal.silver;
            b = medal.bronze;
            result++;
        }
        System.out.println(result);


    }
}