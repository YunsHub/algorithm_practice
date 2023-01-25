import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean find;
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

            if(cnt == 5){
                find = true;
                return;
            }
        }
    }

    public static boolean check(int x, int y){
        return (1<=x && x<20 && 1<=y && y<20);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[20][20];

        for(int i=1; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<20; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        for(int i=1; i<20; i++){
            for(int j=1; j<20; j++){
                if(map[i][j] != '0'){
                    solve(i, j);
                    if(find){
                        System.out.println(map[i][j]-'0');
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}