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
//		if (N == 1) {
//			sb.append("1");
//		} else if (N == 2) {
//			sb.append("12");
//		} else if (N == 3) {
//			sb.append("121");
//		} else if (N == 4) {
//			sb.append("1213");
//		} else if (N == 5) {
//			sb.append("12131");
//		} else if (N == 6) {
//			sb.append("121312");
//		} else if (N == 7) {
//			sb.append("1213121");
//		}

		recur(0, result);

		sb.append(result);
		System.out.println(sb);
	}

//	public static void backtracking(int cur, String num) {
//		if (result.length() == N) {
//			result = num;
//			return;
//		}
//
//		for (int i = 1; i <= 3; i++) {
//			num += i;
//			for (int j = 1; j >= num.length() / 2; j++) {
//				if (num.substring(num.length() - j) == num.substring((num.length() - (2 * j)), (num.length() - j))) {
//					continue;
//				}
//			}
//
////			recur(cur, num + i);
////
////			if (num.charAt(cur) == Integer.toString(i).charAt(0)) {
////				continue;
////			}
//
//		}
//
//	}

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
