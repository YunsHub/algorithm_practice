package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2583 {
	
	static StringBuilder sb = new StringBuilder();
	public static int M, N, K;
	public static boolean arr[][];
	public static int count;
	public static int[] dx = {1, 0, -1 , 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> result = new ArrayList<>();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j = x1; j < x2; j++) {
				for(int k = y1; k < y2; k++) {
					if(!arr[j][k]) {						
						arr[j][k] = true;					
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!arr[i][j]) {
					count = 0;
					dfs(i, j);	
					result.add(count);
				}						
			}
		}
		
		Collections.sort(result);
		
		sb.append(result.size() + "\n");
		for(int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + " ");
		}
		System.out.println(sb);
		
	}

	public static void dfs(int x, int y) {
		arr[x][y] = true;
		count++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if(!arr[nx][ny]) {
					dfs(nx, ny);	
				}			
			}
		}
	}
}
