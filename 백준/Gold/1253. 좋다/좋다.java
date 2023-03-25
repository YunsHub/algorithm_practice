import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2개의 수를 뽑아 합을 true로 바꿔줌
// 자기 자신 포함?
public class Main {
    static int N;
    static int[] num;
    static int[] select;
    static boolean[] visited;
    static int result = 0;
    // 정렬 후 이분탐색
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        visited = new boolean[N];
        select = new int[2];
        result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);

        System.out.println(result);

    }

    // 3
    // 0 0 0
    // 출력 : 3
    // 3
    // -1 0 1
    // 출력 : 1
    public static void comb(int idx, int cnt) {
        if(cnt == 2) {
            int sum = num[select[0]] + num[select[1]];
            for(int i = 0; i < N; i++) {
                if (!visited[i] && num[i] == sum && i != select[0] && i != select[1]) {
                    result++;
                    visited[i] = true;
                }
            }
            return;
        }
        for(int i = idx; i < N ;i++) {
            select[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }
}