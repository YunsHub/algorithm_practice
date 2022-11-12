package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_11725 {

	static int[]arr;
	static ArrayList<Integer>[] arrList;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		arrList = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arrList[i] = new ArrayList<>();
		}
		
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			arrList[from].add(to);
			arrList[to].add(from);

		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
			}				
		}
		
		for(int i = 2; i <= N; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
		

	}
	
	public static void dfs(int x) {
		visited[x] = true;
		
		for(int i : arrList[x]) {
			if(!visited[i]) {
				arr[i] = x;
				dfs(i);
			}
		}
		
	}

}
