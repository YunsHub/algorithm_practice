import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13335 {
    static int N, W, L;
    static Truck[] truck;

    public static class Truck {
        int weight;
        int distance;
        public Truck(int weight) {
            this.weight = weight;
            this.distance = 0;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        truck = new Truck[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
             truck[i] = new Truck(Integer.parseInt(st.nextToken()));
        }

        int next = 0, arrived = 0, total = 0;
        int time = 0;
        while (arrived<N) {

            if(truck[arrived].distance == W){
                total-=truck[arrived].weight;
                arrived++;
            }

            for(int i=arrived; i<next; i++){
                truck[i].distance++;
            }

            time++;

            if(next >= N){ continue;}
            if(total + truck[next].weight <= L){
                total += truck[next].weight;
                truck[next].distance++;
                next++;
            }

        }
        System.out.println(time);
    }
}
