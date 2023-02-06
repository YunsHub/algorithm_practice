import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<int[]> list;
    static boolean[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            arr = new boolean[N + 2][N + 2];

            for(int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            for(int i = 0; i < N + 2; i++) {
                for(int j = 0; j < N + 2; j++) {
                    int[] now = list.get(i);
                    int[] next = list.get(j);
                    int dis = Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]);
                    if(dis <= 1000) {
                        arr[i][j] = true;
                    }
                }
            }

            for(int k = 0; k < N + 2; k++) {
                for(int i = 0; i < N + 2; i++) {
                    for(int j = 0; j < N + 2; j++) {
                        if(arr[i][k] && arr[k][j]) {
                            arr[i][j] = true;
                        }
                    }
                }
            }
            System.out.println(arr[0][N + 1] ? "happy" : "sad");
        }
    }


}