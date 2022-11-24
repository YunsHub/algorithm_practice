package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1967 {

//	12
//	1 2 3
//	1 3 2
//	2 4 5
//	3 5 11
//	3 6 9
//	4 7 1
//	4 8 7
//	5 9 15
//	5 10 4
//	6 11 6
//	6 12 10
	
	static class Node{
		int position;
		int weight;
		public Node(int position, int weight) {
			this.position = position;
			this.weight = weight;
		}
	}
	
	static ArrayList<Node> list[];
	static boolean[] visited;
	static int maxPostion;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		//list = new ArrayList<Node>[N + 1];
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		max = 0;
		maxPostion = 0;
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		for(int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}

		dfs(1, 0);
		max = 0;
		visited = new boolean[N + 1];
		dfs(maxPostion, 0);
		
		System.out.println(max);
		
	}
	
	public static void dfs(int position, int sum) {
		visited[position] = true;
		
		if(sum > max) {
			max = sum;
			maxPostion = position;
		}
		
		
		for(int i = 0; i < list[position].size(); i++) {
			if(visited[list[position].get(i).position]) {
				continue;
			}
			dfs(list[position].get(i).position, sum + list[position].get(i).weight);
		}
		
	}
}
