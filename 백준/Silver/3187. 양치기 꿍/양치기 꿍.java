import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, M, w, s;
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static char map[][];

    public static void dfs(int x, int y){

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]=='#'){continue;}
            if(map[nx][ny]=='v'){w++;}
            else if(map[nx][ny] == 'k'){s++;}
            map[nx][ny] = '#';
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        map = new char[N][M];
        int wolf = 0, sheep = 0;

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != '#'){
                    w = s = 0;
                    if(map[i][j]=='v'){w++;}
                    else if(map[i][j] == 'k'){s++;}
                    map[i][j] = '#';
                    dfs(i, j);
                    if(w < s){
                        sheep += s;
                    }
                    else{
                        wolf += w;
                    }
                }
            }
        }
        System.out.println(sheep+" "+wolf);
    }
}