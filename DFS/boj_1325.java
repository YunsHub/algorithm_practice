package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1325 {

	static ArrayList<Integer>[] arrList;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arrList = new ArrayList[N + 1];
		arr = new int[N + 1];
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			arrList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			arrList[from].add(to);			
		}
		
		for(int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];
				dfs(i);
			
		}
		
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, arr[i]);
		}
		
		for(int i = 1; i <= N; i++) {
			if(max == arr[i]) {
				System.out.print(i + " ");
			}
		}
		
	}
	
	public static void dfs(int x) {
		visited[x] = true;
		
		for(int i : arrList[x]) {
			if(!visited[i]) {
				arr[i]++; 
				dfs(i);
			}		
		}
	}
}
