import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] S = stoi(st.nextToken());
        int[] E = stoi(st.nextToken());
        int[] Q = stoi(st.nextToken());

        Set<String> participants = new HashSet<>();
        int result = 0;
        String record;
        while ((record = br.readLine()) != null) {
//            if(record.length() == 0){
//                break;
//            }
            st = new StringTokenizer(record);
            int[] time = stoi(st.nextToken());
            String name = st.nextToken();

            if (time[0] < S[0] || (time[0] == S[0] && time[1] <= S[1])) {
                participants.add(name);
            } else if ((time[0] > E[0] || (time[0] == E[0] && time[1] >= E[1]))
                    && (time[0] < Q[0] || (time[0] == Q[0] && time[1] <= Q[1]))) {
                if (participants.contains(name)) {
                    participants.remove(name);
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    public static int[] stoi(String time) {
        String[] temp = time.split(":");
        return new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
    }
}