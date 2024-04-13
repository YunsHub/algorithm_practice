import java.util.*;
import java.io.*;

class Main
{
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static char[][] board;
    public static boolean[][][][] visited;
    public static int N, M;
    public static int answer = Integer.MAX_VALUE;

    public static class Ball {
        int x;
        int y;
        int order;
        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void moveTo(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void updateOrder(int order) {
            this.order = order;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        Ball redBall = null;
        Ball blueBall = null;
        int[] hole = new int[2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'R') {
                    redBall = new Ball(i, j);
                }
                else if(board[i][j] == 'B') {
                    blueBall = new Ball(i, j);
                } else if(board[i][j] == 'O') {
                    hole[0] = i;
                    hole[1] = j;
                }
            }
        }

        permutation(0, redBall, blueBall, hole);


        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }


    public static void permutation(int cnt, Ball redBall, Ball blueBall, int[] hole) {
        if(cnt > 10){
            // 10번 이하 or 빨간 구슬 성공
            return;
        }

        if(redBall.x == hole[0] && redBall.y == hole[1]) {
            if(blueBall.x != hole[0] || blueBall.y != hole[1]) {
                answer = Math.min(answer, cnt);
            }
            return;
        }

        if(blueBall.x == hole[0] && blueBall.y == hole[1]) {
            return;
        }

        int rx = redBall.x;
        int ry = redBall.y;
        int bx = blueBall.x;
        int by = blueBall.y;

        for(int i = 0; i < 4; i++) {
            if(!visited[redBall.x][redBall.y][blueBall.x][blueBall.y]) {
                visited[redBall.x][redBall.y][blueBall.x][blueBall.y] = true;
                getOrder(i, redBall, blueBall);
                if(redBall.order == 1) {
                    simulation(i, redBall, 'R');
                    simulation(i, blueBall, 'B');
                } else {
                    simulation(i, blueBall, 'B');
                    simulation(i, redBall, 'R');
                }

                permutation(cnt+1, redBall, blueBall, hole);

                if(board[redBall.x][redBall.y] == 'O') {
                    board[redBall.x][redBall.y] = 'O';
                } else {
                    board[redBall.x][redBall.y] = '.';
                }

                if(board[blueBall.x][blueBall.y] == 'O') {
                    board[blueBall.x][blueBall.y] = 'O';
                } else {
                    board[blueBall.x][blueBall.y] = '.';
                }

                redBall.moveTo(rx, ry);
                blueBall.moveTo(bx, by);
                board[redBall.x][redBall.y] = 'R';
                board[blueBall.x][blueBall.y] = 'B';

                visited[redBall.x][redBall.y][blueBall.x][blueBall.y] = false;
            }


        }
    }

    public static void simulation(int dir, Ball ball, char color) {
        while(true) {
            int nx = ball.x + dx[dir];
            int ny = ball.y + dy[dir];
            if(board[nx][ny] == '#' || board[nx][ny] == 'R' || board[nx][ny] == 'B') break;
            board[ball.x][ball.y] = '.';
            ball.moveTo(nx, ny);
            if(board[nx][ny] == 'O') {
                break;
            }

            board[nx][ny] = color;
        }
    }

    public static void getOrder(int dir, Ball redBall, Ball blueBall) {
        if(dir==0) {
            if(redBall.y >= blueBall.y) {
                redBall.updateOrder(1);
                blueBall.updateOrder(2);
            } else {
                redBall.updateOrder(2);
                blueBall.updateOrder(1);
            }
        } else if(dir==1) {
            if(redBall.x >= blueBall.x) {
                redBall.updateOrder(1);
                blueBall.updateOrder(2);
            } else {
                redBall.updateOrder(2);
                blueBall.updateOrder(1);
            }
        } else if(dir==2) {
            if(redBall.y <= blueBall.y) {
                redBall.updateOrder(1);
                blueBall.updateOrder(2);
            } else {
                redBall.updateOrder(2);
                blueBall.updateOrder(1);
            }
        } else {
            if(redBall.x <= blueBall.x) {
                redBall.updateOrder(1);
                blueBall.updateOrder(2);
            } else {
                redBall.updateOrder(2);
                blueBall.updateOrder(1);
            }
        }
    }


}