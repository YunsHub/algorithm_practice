package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_10026 {
	
	static int N;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		int result = 0;
		int result2 = 0;
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				char word = str.charAt(j);
				arr[i][j] = word;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					result++;
				}			
			}
		}
		
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}			
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					result2++;
				}			
			}
		}
		
		
		System.out.println(result + " " + result2);
		
	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		char color = arr[x][y];
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
						
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {			
				if(arr[nx][ny] == color && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

}
