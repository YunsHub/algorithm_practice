package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class id_4153 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int[] num = new int[3];
			for (int i = 0; i < 3; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);

			if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
				break;
			}

			if (Math.pow(num[2], 2) == Math.pow(num[0], 2) + Math.pow(num[1], 2)) {
				bw.write("right\n");
			} else {
				bw.write("wrong\n");
			}

		}

		br.close();
		bw.flush();
		bw.close();
	}
}
