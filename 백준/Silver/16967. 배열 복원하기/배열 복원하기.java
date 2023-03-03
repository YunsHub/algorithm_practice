import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] Aarr = new int[H][W];
        int[][] Barr = new int[H + X][W + Y];

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                Barr[i][j] = Integer.parseInt(st.nextToken());

                if(i - X >= 0 && j - Y >= 0) {
                    Aarr[i][j] = Barr[i][j] - Aarr[i - X][j - Y];
                } else{
                    Aarr[i][j] = Barr[i][j];
                }
                sb.append(Aarr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}