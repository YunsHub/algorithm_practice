package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4963 {
	static int[][] arr;
	static boolean[][] visited;
	static int w, h;
	static int result;
	static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				break;
			} else {
				arr = new int[h][w];
				visited = new boolean[h][w];
				result = 0;
				
				for(int i = 0; i < h; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j = 0; j < w; j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());					
					}
				}
				
				for(int i = 0; i < h; i++) {		
					for(int j = 0; j < w; j++) {
						if(!visited[i][j] && arr[i][j] == 1) {
							dfs(i, j);
							result++;
						}										
					}
				}
				
				sb.append(result + "\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
				if(arr[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
		
	}

}
