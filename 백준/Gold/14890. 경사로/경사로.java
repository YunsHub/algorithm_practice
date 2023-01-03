import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] arr;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N];
        result = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            if(row(i)){
                result++;
            }
            if(column(i)) {
                result++;
            }
        }

        

        System.out.println(result);
    }



    public static boolean column(int y) {
        int count = 1;
        int now = arr[0][y];
        for(int i = 1; i < N; i++) {
            if(now == arr[i][y]) {
                count++;
                continue;
            }
            else if(now + 1 == arr[i][y]) {
                if(count < L) {
                    return false;
                } else {
                    count = 1;
                    now = arr[i][y];
                }
            }
            else if(now - 1 == arr[i][y]) {
                for(int j = 0; j < L; j++) {
                    if(i + j >= N || arr[i + j][y] != arr[i][y]) {
                        return false;
                    }
                }
                i += L - 1;
                count = 0;
                now = arr[i][y];
            }
            else {
                return false;
            }
        }
        return true;
    }


    public static boolean row(int x) {
        int count = 1;
        int now = arr[x][0];
        for(int i = 1; i < N; i++) {
            if(now == arr[x][i]) {
                count++;
                continue;
            }
            else if(now + 1 == arr[x][i]) {
                if(count < L) {
                    return false;
                } else {
                    count = 1;
                    now = arr[x][i];
                }
            }
            else if(now - 1 == arr[x][i]) {
                for(int j = 0; j < L; j++) {
                    if(i + j >= N || arr[x][i + j] != arr[x][i]) {
                        return false;
                    }
                }
                i += L - 1;
                count = 0;
                now = arr[x][i];
            }
            else {
                return false;
            }
        }
        return true;
    }


}