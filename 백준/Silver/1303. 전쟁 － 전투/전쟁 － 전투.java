import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int count, wcount, bcount;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[M][N];
		visited = new boolean[M][N];
		wcount = 0;
		bcount = 0;
		
		for(int i = 0 ; i < M; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		
		for(int i = 0 ; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					count = 0;
					dfs(i, j, arr[i][j]);
					if(arr[i][j] == 'W') {
						wcount += (int) Math.pow(count, 2);
					} else {
						bcount += (int) Math.pow(count, 2);
					}
				}
			}
		}
		
		System.out.println(wcount + " " + bcount);
		
		

	}

	public static void dfs(int x, int y, char c) {
		visited[x][y] = true;
		count += 1;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if(!visited[nx][ny] && arr[nx][ny] == c) {
					dfs(nx, ny, c);
				}
			}
		}
		
	}
}
