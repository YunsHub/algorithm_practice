package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2606 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] arr;
	static boolean[] check;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		check = new boolean[N+1];
		count = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		dfs(1);
		sb.append(count - 1);
		System.out.println(sb);
	}
	
	public static void dfs(int start) {
		check[start] = true;
		count++;
		for(int i = 0; i <= M; i++) {
			if(arr[start][i] == 1 && !check[i]) {
				dfs(i);			
			}			
		}
		
	}

}
