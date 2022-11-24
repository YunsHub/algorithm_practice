package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13565 {

	static int M, N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		visited = new boolean[M][N];
		result = false;
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(arr[0][i] == 0) {
				dfs(0, i);
			}		
		}
		
		System.out.println(result ? "YES" : "NO");

	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;		
		
		if(x == M - 1) {
			result = true;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if(arr[nx][ny] == 0 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
		
				
	}
}
