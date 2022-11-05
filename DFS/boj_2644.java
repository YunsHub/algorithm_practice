package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2644 {

	static int N, A, B, M;
	static int[][] arr;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		result = -1;
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		
		dfs(A, B, 0);
		
		System.out.println(result);
	}

	public static void dfs(int start, int end, int count) {
		if(start == end) {
			result = count;
			return;
		}
		
		visited[start] = true;
		
		for(int i = 1; i <= N; i++) {
			if(arr[start][i] == 1 && !visited[i]) {
				dfs(i, end, count + 1);
			}
			
		}
	}
}
