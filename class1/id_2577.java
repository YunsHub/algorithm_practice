package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class id_2577 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int mul = A * B * C;
		int[] cnt = new int[10];
		while (mul != 0) {
			cnt[mul % 10]++;
			mul /= 10;
		}
		for(int result : cnt) {
			System.out.println(result);
		}
	}
}
