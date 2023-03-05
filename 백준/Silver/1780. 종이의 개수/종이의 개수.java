import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        cut(0, 0, N);
        StringBuilder sb = new StringBuilder();
        for(int n : result){
            sb.append(n).append("\n");
        }
        System.out.println(sb);

    }

    public static void cut(int x, int y, int size){
        int no = arr[x][y];
        boolean isSame = true;
        int xSize = x + size;
        int ySize = y + size;
        outloop : for(int i=x; i<xSize; i++){
            for(int j=y; j<ySize; j++){
                if(arr[i][j] != no){
                    isSame = false;
                    break outloop;
                }
            }
        }

        if(!isSame){
            int cutSize = size / 3;
            for(int i=x; i<xSize; i+=cutSize){
                for(int j=y; j<ySize; j+=cutSize){
                    cut(i, j, cutSize);
                }
            }

        }
        else{
            result[no]++;
        }
    }
}