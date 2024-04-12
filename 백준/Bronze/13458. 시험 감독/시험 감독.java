import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rooms = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        long answer = rooms.length;
        for (int i = 0; i < N; i++) {
            rooms[i] -= A;
        }

        for(int room : rooms) {
            if(room <= 0) continue;
            answer += (room/B);
            if(room%B != 0) answer++;
        }
        System.out.println(answer);
    }


}