package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11724 {

	static int N, M;
	static int[][] arr;
	static boolean[] check;
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[1001][1001];
		check = new boolean[1001];
		count = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!check[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void dfs(int i) {
		if(check[i]) {
			return;
		}
		
		check[i] = true;
		
		for(int j = 1; j <= N; j++) {
			if(arr[i][j] == 1 && !check[j]) {
				dfs(j);
			}
		}
	}
}
