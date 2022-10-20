package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class id_1546 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		double[] score = new double[N];
		double max = -1;
		double avg = 0.0;
		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if (max < score[i]) {
				max = score[i];
			}
		}

		for (int i = 0; i < N; i++) {
			score[i] = score[i] / max * 100;
			sum += score[i];
		}
		avg = sum / N;

		System.out.println(avg);
	}

}
