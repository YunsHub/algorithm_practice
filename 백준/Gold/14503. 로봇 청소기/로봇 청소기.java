import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    // 북 동 남 서
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int rx = Integer.parseInt(st.nextToken());
        int ry = Integer.parseInt(st.nextToken());
        int rDir = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(true) {
            // 1. 현재 칸 청소
            if(map[rx][ry] == 0) {
                map[rx][ry] = 2;
                answer++;
            }

            boolean check = false;
            for(int dir=0; dir<4; dir++) {
                int nx = rx + dx[dir];
                int ny = ry + dy[dir];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(map[nx][ny] == 0) {
                    check = true;
                    break;    
                }
            }

            // 2. 주변 4칸 0이 없는 경우, 후진
            if(!check) {
                int backDir = (rDir+2) % 4;
                rx += dx[backDir];
                ry += dy[backDir];
                if(rx<0 || ry<0 || rx>=N || ry>=M) break;
                if(map[rx][ry]==1) break;
            } else {
                
                // 3. 주변 4칸 0이 있는 경우, 반시계 90도 회전
                rDir = (rDir+3) % 4;
                
                // 앞 칸 0이면 전진
                int nx = rx + dx[rDir];
                int ny = ry + dy[rDir];
                if((nx>=0 && ny>=0 && nx<N && ny<M) && map[nx][ny] == 0) {
                    rx = nx;
                    ry = ny;
                } 
            }
        }
        

        
        System.out.println(answer);
    }
}
