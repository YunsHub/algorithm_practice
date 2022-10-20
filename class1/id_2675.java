package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class id_2675 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String[] S = st.nextToken().split("");
			for(int i = 0; i < S.length; i++) {
				for(int j = 0; j < R; j++) {
					System.out.print(S[i]);
				}				
			}
			System.out.println();
		}
	}

}
