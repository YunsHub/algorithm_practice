import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static int winner, wx, wy;
    static int[] dx = {-1, 0, 1, 1}, dy = {1, 1, 1, 0};

    public static void solve(int x, int y){
        char color = map[x][y];

        for(int i = 0; i < 4; i++){
            //1. 반대방향
            int nx = x + dx[i] * (-1);
            int ny = y + dy[i] * (-1);
            if(check(nx, ny) && color == map[nx][ny]){continue;}

            //2. 5개 검사
            int cnt = 1;
            nx = x;
            ny = y;
            while(cnt < 6){
                nx += dx[i];
                ny += dy[i];
                if(!check(nx, ny) || color != map[nx][ny]){ break;}
                cnt++;
            }
//            System.out.println(cnt);
            if(cnt == 5){
                winner = color - '0';
                wx = x + 1;
                wy = y + 1;
                return;
            }
        }
    }

    public static boolean check(int x, int y){
        return (0<=x && x<19 && 0<=y && y<19);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[19][19];

        for(int i=0; i<19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                if(map[i][j] != '0'){
                    solve(i, j);
                    if(winner != 0){
                        System.out.println(winner);
                        System.out.println(wx + " " + wy);
                        return;
                    }
                }
            }
        }

        System.out.println(winner);
    }
}