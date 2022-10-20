package class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class id_10809 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		String S = br.readLine();
		for (int i = 0; i < S.length(); i++) {
			if (arr[S.charAt(i) - 97] == -1) {
				arr[S.charAt(i) - 97] += (i + 1);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
