package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class id_2475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int[] num = new int[5];
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			num[i] *= num[i];
			sum += num[i];
		}
		System.out.println(sum % 10);
		
		
	}

}
