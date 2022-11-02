package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2636 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static int time, count;
	static boolean check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());	
		
		map = new int[N][M];
		
		count = 0;
		time = 0;
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		while(true) {
			visited = new boolean[N][M];
			count = 0;
			time++;
			dfs(0, 0);
			check = true;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						check = false;
						break;
					}
				}
				if(!check) {
					break;
				}
			}
			
			if(check) {
				System.out.println(time);
				System.out.println(count);
				return;		
			}	
		}
		
		
	}

	
	public static void dfs(int x,int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(idxCheck(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
				count++;
				map[nx][ny] = 0;
				visited[nx][ny] = true;
			}
			
			if(idxCheck(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
			
		}
		
		
	}
	
	private static boolean idxCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    } 
}
