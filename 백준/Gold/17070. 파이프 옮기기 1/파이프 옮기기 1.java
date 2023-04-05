import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 파이프 미는 문제
	// 가로 - 2방향
	// 세로 - 2방향
	// 대각선 - 3방향

	public static int N;
	public static int[][] map;
	public static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 1, 0);
		
		sb.append(count);
		System.out.println(sb);
	}

	// 가로 0
	// 세로 1
	// 대각선 2
	public static void DFS(int x, int y, int dir) {
		if (x == N - 1 && y == N - 1) {
			count++;
			return;
		}

		// 가로
		if (dir == 0) {
			// 오른쪽
			if (y + 1 < N && map[x][y + 1] == 0) {
				DFS(x, y + 1, 0);
			}
			// 대각선
			if (x + 1 < N && y + 1 < N && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
				DFS(x + 1, y + 1, 2);
			}
		} else if (dir == 1) {
			// 아래
			if (x + 1 < N && map[x + 1][y] == 0) {
				DFS(x + 1, y, 1);
			}
			// 대각선
			if (x + 1 < N && y + 1 < N && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
				DFS(x + 1, y + 1, 2);
			}
		} else if (dir == 2) {
			// 오른쪽
			if (y + 1 < N && map[x][y + 1] == 0) {
				DFS(x, y + 1, 0);
			}
			// 아래
			if (x + 1 < N && map[x + 1][y] == 0) {
				DFS(x + 1, y, 1);
			}
			// 대각선
			if (x + 1 < N && y + 1 < N && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
				DFS(x + 1, y + 1, 2);
			}

		}

	}

}
