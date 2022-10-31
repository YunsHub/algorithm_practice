import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2661 {
	static StringBuilder sb = new StringBuilder();
	public static int N;
	public static String result;
	public static boolean success;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = "";
		success = false;

		recur(0, result);

		sb.append(result);
		System.out.println(sb);
	}


	public static void recur(int cur, String num) {
		if (success) {
			return;
		}
		if (!check(num)) {
			return;
		}

		if (cur == N) {
			success = true;
			result = num;
			return;
		}
		for (int i = 1; i <= 3; i++) {
			recur(cur + 1, num + Integer.toString(i).charAt(0));
		}
		return;
	}

	public static boolean check(String num) {
		for (int j = 1; j <= num.length() / 2; j++) {
			if (num.substring(num.length() - j).equals(num.substring((num.length() - (2 * j)), (num.length() - j)))) {
				return false;
			}
		}
		return true;
	}

}
