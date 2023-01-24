import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<String> visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static int bfs(char[][] start){
        int result = 0;
        Queue<char[][]> q = new LinkedList<>();
        q.add(start);
        String s = toString(start);
        if(s.equals("123456780")){return 0;}
        visited.add(s);

        while(!q.isEmpty()){
            result++;
            for(int i = 0, size = q.size(); i < size; i++){
                char[][] now = q.poll();
                int x = 0, y = 0;
                //deep copy
                for(int a=0; a<3; a++){
                    for(int b=0; b<3; b++){
                        if(now[a][b] == '0'){
                            x = a;
                            y = b;
                        }
                    }
                }

                for(int j=0; j<4; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx<0 || nx>=3 || ny<0 || ny>=3){ continue;}
                    char[][] next = new char[3][3];
                    for(int a = 0; a < 3; a++){
                        for(int b = 0; b < 3; b++){
                            next[a][b] = now[a][b];
                        }
                    }
                    next[x][y] = next[nx][ny];
                    next[nx][ny] = '0';
                    s = toString(next);
                    if(visited.contains(s)){ continue;}
                    if(s.equals("123456780")){ return result;}
                    visited.add(s);
                    q.add(next);
                }
            }
        }
        return -1;
    }

    public static String toString(char[][] input){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                sb.append(input[i][j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        visited = new HashSet<>();

        char[][] map = new char[3][3];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
//                input = (input * 10) + (Integer.parseInt(st.nextToken()) + 1);
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        System.out.println(bfs(map));

    }
}