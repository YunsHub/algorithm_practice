import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, result;
    static int[][] arr;
    static boolean[][] cloud;
    //static ArrayList<int[]> list;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        cloud = new boolean[N][N];
        cloud[N-1][0] = cloud[N-1][1] = cloud[N-2][0] = cloud[N-2][1] = true;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            simulation(d - 1 ,s % N);
        }

        result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                result += arr[i][j];
            }
        }

        System.out.println(result);
    }
    public static void simulation(int direction, int speed) {

        // 1. 모든 구름이 d방향으로 s칸 이동한다.
        boolean next[][] = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud[i][j]){
                    int nx = (N + i + dx[direction] * speed) % N;
                    int ny = (N + j + dy[direction] * speed) % N;
                    next[nx][ny] = true;
                    arr[nx][ny] ++; // 2.각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
                }
            }
        }
        cloud = next;

        // 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud[i][j]){
                    for(int d = 1; d < 8; d+=2){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) {continue;}
                        if(arr[nx][ny] > 0) {
                            arr[i][j]++;
                        }
                    }
                }
            }
        }

        // 3. 구름이 모두 사라진다.
        // 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cloud[i][j]){
                    cloud[i][j] = false;
                }
                else if(arr[i][j] >= 2) {
                    arr[i][j] -= 2;
                    cloud[i][j] = true;
                }
            }
        }
    }
}