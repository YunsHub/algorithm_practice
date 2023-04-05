import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static long[][] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        a = new long[n][2];
        long totalPeople = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Long.parseLong(st.nextToken()); // 위치
            a[i][1] = Long.parseLong(st.nextToken()); // 인구 수
            totalPeople += a[i][1];
        }
        Arrays.sort(a, Comparator.comparingLong(o -> o[0])); // 위치 기준으로 정렬
        long targetPeople = (totalPeople % 2 == 0) ? totalPeople / 2 : totalPeople / 2 + 1;
        long currentPeople = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            currentPeople += a[i][1];
            if (currentPeople >= targetPeople) {
                ans = a[i][0];
                break;
            }
        }
        System.out.println(ans);
    }
}