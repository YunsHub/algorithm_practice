package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class id_1018 {
	static boolean[][] board; 
	static int count = 0;
	static int min = 64;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				if(str.charAt(j) == 'W') {
					board[i][j] = true;
				} else {
					board[i][j] = false;
				}
			}
		}
		
		
		for(int i = 0; i < N - 7; i++) {
			for(int j = 0; j < M - 7; j++) {
				solve(i, j);
			}
		}
		bw.write(min + "");
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void solve(int x, int y) {
		count = 0;
		boolean result = board[x][y];
		for(int i = x; i < x + 8; i++) {
			for(int j = y; j < y + 8; j++) {
				if(result != board[i][j]) {	// 다를경우
					count++;
				}
				result = !result;
			}
			result = !result;
		}
		
		count = Math.min(count, 64 - count);
		
		min = Math.min(min, count);
	}

}
