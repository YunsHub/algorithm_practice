import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_16918 {
    static class Node {
        int R;
        int C;
        public Node(int R, int C){
            this.R = R;
            this.C = C;
        }
    }

    static int R, C, N;
    static char[][] arr;
    static ArrayList<Node> list;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        list = new ArrayList<>();


        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        int second = 1;
        while (true){
            if(second == N){
                break;
            }
            second++;
            list = new ArrayList<>();
            find();
            fill();
            if(second == N){
                break;
            }
            second++;
            boom();
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void boom() {
        for(int i = 0; i < list.size(); i++){
            int x = list.get(i).R;
            int y = list.get(i).C;

            arr[x][y] = '.';

            for(int j = 0; j < 4; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(nx >= 0 && ny >= 0 && nx < R && ny < C){
                    arr[nx][ny] = '.';
                }
            }
        }
    }

    public static void fill() {
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                arr[i][j] = 'O';
            }
        }
    }

    public static void find() {
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(arr[i][j] == 'O'){
                    list.add(new Node(i, j));
                }
            }
        }
    }
}
