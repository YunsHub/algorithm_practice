package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class id_2775 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[][] people = new int[15][15];

		for (int i = 0; i < 15; i++) {
			people[i][1] = 1;
			people[0][i] = i;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				people[i][j] = people[i - 1][j] + people[i][j - 1];

			}
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			bw.write(people[k][n] + "\n");
		}

		br.close();
		bw.flush();
		bw.close();

	}

}
