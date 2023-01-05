import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = stoi(st.nextToken());
        int E = stoi(st.nextToken());
        int Q = stoi(st.nextToken());

        Set<String> participants = new HashSet<>();
        int result = 0;
        String record;
        while ((record = br.readLine()) != null) {
            st = new StringTokenizer(record);
            int time = stoi(st.nextToken());
            String name = st.nextToken();

            if(time <= S){
                participants.add(name);
            }
            else if(E <= time && time <= Q){
                if(participants.contains(name)){
                    participants.remove(name);
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    public static int stoi(String time){
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }
}