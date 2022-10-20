package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class id_2739 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i < 10; i++) {
			System.out.println(N + " * " + i + " = " +(N * i));
		}

	}

}
