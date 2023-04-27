import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int whiteCnt, blueCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        whiteCnt = 0;
        blueCnt = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paper(0, 0, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);

    }
    public static void paper(int row, int column, int n) {
        if(check(row, column ,n)) {
            if(arr[row][column] == 0) {
                whiteCnt++;
            } else {
                blueCnt++;
            }
        } else {
            paper(row, column, n / 2);
            paper(row, column + n / 2, n / 2);
            paper(row + n / 2, column, n / 2);
            paper(row + n / 2, column + n /2, n / 2);
        }
    }
    public static boolean check(int row, int column, int n) {
        int color = arr[row][column];
        for(int i = row; i < row + n; i++) {
            for(int j = column; j < column + n; j++) {
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}