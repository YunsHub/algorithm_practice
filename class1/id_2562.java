package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class id_2562 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[9];
		int max = 0;
		int cnt = -1;
		for(int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if(max < num[i]) {
				max = num[i];
				cnt = i;
			}			
		}
		System.out.println(max);
		System.out.println(cnt + 1);
	}

}
