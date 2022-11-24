package DFS;
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	public class boj_3184 {
	
		static int R, C;
		static char[][] arr;
		static boolean[][] visited;
		static int Scount, Wcount;
		static int Slive, Wlive;
		static int[] dx = { 1, 0, -1, 0 };
		static int[] dy = { 0, -1, 0, 1 };
	
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			Slive = 0;
			Wlive = 0;
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			arr = new char[R][C];
			visited = new boolean[R][C];
	
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
	
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!visited[i][j] && arr[i][j] != '#') {
						Scount = 0;
						Wcount = 0;
						dfs(i, j);
						// 양 count 가 많으면 양이 이김
						if(Scount > Wcount) {
							Slive += Scount;
						} else if(Scount <= Wcount) {
							Wlive += Wcount;
						}
					}
				}
			}
			
			System.out.println(Slive + " " + Wlive);
	
		}
	
		public static void dfs(int x, int y) {
			visited[x][y] = true;
			
			if (arr[x][y] == 'o') {
				Scount++;
			} else if (arr[x][y] == 'v') {
				Wcount++;
			}
	
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
	
				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
					if (!visited[nx][ny] && arr[nx][ny] != '#') {
						dfs(nx, ny);
					}
				}
			}
		}
	
	}
