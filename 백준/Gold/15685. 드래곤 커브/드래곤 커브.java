import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { 0, -1, 0, 1 }; // 왼, 위, 오른, 아래
	static int[] dx = { 1, 0, -1, 0 };

	static int N;
	static boolean[][] map;

	static int result;

	static void dragonCurve(int x, int y, int d, int g) {
		int[] moveHistory = new int[1024];
		// 0세대 초기화
		// 시작 지점
		map[y][x] = true;
		y += dy[d];
		x += dx[d];
		// 끝 지점
		map[y][x] = true;

		moveHistory[0] = d;

		// 1세대부터 g세대까지 반복
		for (int i = 1; i <= g; i++) {
			// moveHistory를 저장할 시작 인덱스
			int startIdx = (int) Math.pow(2, i - 1);
			// 끝 인덱스
			int endIdx = (int) Math.pow(2, i) - 1;
			// moveHistory를 역순으로 탐색할 인덱스
			int backIdx = startIdx - 1;

			for (int j = startIdx; j <= endIdx; j++) {
				d = (moveHistory[backIdx] + 1) % 4;

				y += dy[d];
				x += dx[d];
				map[y][x] = true;

				moveHistory[j] = d;
				backIdx--;
			}

		}
	}

	static void checkSquare() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
					result++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		N = Integer.parseInt(br.readLine());
		map = new boolean[150][150];

		result = 0;
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			dragonCurve(x, y, d, g);
		}

		checkSquare();

		System.out.println(result);

		br.close();
	}

}