import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int N;
	static int[] arr;
	static boolean[] visited;
	static boolean[] checked;
	static ArrayList<Integer> arrList;
	static ArrayList<Integer> resultList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		
		resultList = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {			
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i = 1; i <= N; i++) {		
			if(!visited[i]) {
				checked = new boolean[N + 1];
				arrList = new ArrayList<>();
				dfs(i, i);
			}
		}
		
		Collections.sort(resultList);
		System.out.println(resultList.size());
		for(int i : resultList) {
			System.out.println(i);
		}
		
	}
	
	public static void dfs(int x, int start) {
		if(checked[x]) {
			return;
		}
		arrList.add(x);
		checked[x] = true;
		if(arr[x] == start) {
			for(int i : arrList) {
				resultList.add(i);
				visited[i] = true;	
			}
			return;
		}
		
		dfs(arr[x], start);
	}

}
