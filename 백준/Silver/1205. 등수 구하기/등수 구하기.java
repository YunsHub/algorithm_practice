import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int tasueScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Integer[] rankList = new Integer[N];
        int rank = 1;

        if(N == 0) {
            rank = 1;
        } else {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                rankList[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(rankList, Collections.reverseOrder());

            if(N == P && rankList[rankList.length - 1] >= tasueScore) {
                rank = -1;
            } else {
                for(int i = 0; i < N; i++) {
                    if(tasueScore >= rankList[i]) {
                        break;
                    } else {
                        rank++;
                    }
                }
            }
        }


        System.out.println(rank);
    }
}