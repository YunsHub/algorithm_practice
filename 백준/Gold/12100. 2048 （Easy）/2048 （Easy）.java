import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    // 북 동 남 서
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int N;
    public static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int[][] board = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //right(board);
        permutation("", 0, board);
        
        System.out.println(answer);
    }

    public static int getMaxValue(int[][] board) {
        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }

    public static void pr(int[][] b) {
        for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                         System.out.print(b[i][j]);
                    }
                            System.out.println();
                }
System.out.println();
    }
    
    public static void permutation(String strDir, int cnt, int[][] board) {
        
        
        if(cnt == 5) {
            answer = Math.max(answer, getMaxValue(board));
            
            // System.out.println(strDir);
            return;
        }

        
        int[][] prevBoard = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                prevBoard[i][j] = board[i][j];
            }
        }
        
        for(int i=0; i<4; i++) {
            simulation(i, board);
            
            permutation(strDir + Integer.toString(i), cnt+1, board);
            // board = prevBoard;
            for(int a=0; a<N; a++) {
            for(int b=0; b<N; b++) {
                board[a][b] = prevBoard[a][b];
            }
        }
        }
    }

    public static void simulation(int dir, int[][] board) {
        if(dir == 0) {
            left(board);
        } else if(dir == 1) {
            right(board);
        } else if(dir==2) {
            up(board);
        } else {
            down(board);
        }
    }

    public static void left(int[][] board) {
        for(int i=0; i<N; i++) {
            int index = 0;
            int prevNum = 0;
            for(int j=0; j<N; j++) {
                if(board[i][j] != 0) {
                    if(prevNum == board[i][j]) {
                        board[i][index-1] = prevNum * 2;
                        prevNum = 0;
                    } else {
                        board[i][index++] = board[i][j];
                        prevNum = board[i][j];
                    }
                    if(index-1 != j) board[i][j] = 0;
                }
            }
        }
    }

    public static void right(int[][] board) {
        for(int i=0; i<N; i++) {
            int index = N-1;
            int prevNum = 0;
            for(int j=N-1; j>=0; j--) {
                if(board[i][j] != 0) {
                    if(prevNum == board[i][j]) {
                        board[i][index+1] = prevNum * 2;
                        prevNum = 0;
                    } else {
                        board[i][index--] = board[i][j];
                        prevNum = board[i][j];
                    }
                    if(index+1 != j) board[i][j] = 0;
                }
            }
        }
    }

    public static void up(int[][] board) {
        for(int i=0; i<N; i++) {
            int index = 0;
            int prevNum = 0;
            for(int j=0; j<N; j++) {
                if(board[j][i] != 0) {
                    if(prevNum == board[j][i]) {
                        board[index-1][i] = prevNum * 2;
                        prevNum = 0;
                    } else {
                        board[index++][i] = board[j][i];
                        prevNum = board[j][i];
                    }
                    if(index-1 != j) board[j][i] = 0;
                }
            }
        }
    }

   public static void down(int[][] board) {
        for(int i=N-1; i>=0; i--) {
            int index = N-1;
            int prevNum = 0;
            for(int j=N-1; j>=0; j--) {
                if(board[j][i] != 0) {
                
                    if(prevNum == board[j][i]) {
                        board[index+1][i] = prevNum * 2;
                        prevNum = 0;
                    } else {
                        board[index--][i] = board[j][i];
                        prevNum = board[j][i];
                    }
                    if(index+1 != j) board[j][i] = 0;
                    
                }
            }
        }
    }

    
}