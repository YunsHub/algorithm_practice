import java.io.BufferedReader;
import java.io.InputStreamReader;

// 게임 최종 판결 조건
// X의 개수 = O의 개수 + 1 (x가 이김)
// X의 개수 = O의 개수 (o가 이김)

public class Main {
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String input = br.readLine();
            if(input.equals("end")){
                break;
            }
            map = new char[3][3];
            int xCnt = 0;
            int oCnt = 0;
            int idx = 0;

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    map[i][j] = input.charAt(idx++);
                    if(map[i][j] == 'X') {
                        xCnt++;
                    } else if(map[i][j] == 'O') {
                        oCnt++;
                    }
                }
            }

            if(xCnt == oCnt + 1) {  // x가 이김
                if(xCnt + oCnt == 9 && !bingo('O')) {
                    sb.append("valid").append("\n");
                }
                else if(!bingo('O') && bingo('X')) {
                    sb.append("valid").append("\n");
                } else{
                    sb.append("invalid").append("\n");
                }
            } else if (xCnt == oCnt) {  //o가 이김
                if(!bingo('X') && bingo('O')) {
                    sb.append("valid").append("\n");
                } else{
                    sb.append("invalid").append("\n");
                }
            } else {
                sb.append("invalid").append("\n");
            }


        }
        System.out.println(sb);
    }

    public static boolean bingo(char c) {
        // 가로
        for(int i = 0; i < 3; i++) {
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) {
                return true;
            }
        }
        // 세로
        for(int i = 0; i < 3; i++) {
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c) {
                return true;
            }
        }
        // 대각선
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }

        if(map[0][2] == c && map[1][1] == c && map[2][0] == c) {
            return true;
        }

        return false;
    }
}