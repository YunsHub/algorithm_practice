import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1240 {

	static class Node {
		int position;
		int distance;
		public Node(int position, int distance) {
			this.position = position;
			this.distance = distance;
		}
	}
	
	static int N, M;
	static ArrayList<Node>[] arr;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		arr = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			arr[start].add(new Node(end, distance));
			arr[end].add(new Node(start, distance));
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			visited = new boolean[N + 1]; 
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			result = 0;
			dfs(start, 0, end);
			sb.append(result + "\n");
		}
 		
		System.out.println(sb);
	}
	
	public static void dfs(int startPosition, int sum, int endPosition) {
		visited[startPosition] = true;
		
		if(startPosition == endPosition) {
			result = sum;
			return;
		}
		
		for(int i = 0; i < arr[startPosition].size(); i++) {
			if(!visited[arr[startPosition].get(i).position]) {
				dfs(arr[startPosition].get(i).position, sum + arr[startPosition].get(i).distance, endPosition);
			}
		}
	}

}