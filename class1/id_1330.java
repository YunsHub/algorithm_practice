package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class id_1330 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		String C = "?";
		
		if(A > B) {
			C = ">";
		}
		else if(A < B) {
			C = "<";
		}
		else {
			C = "==";
		}				
		System.out.println(C);
		br.close();
	}

}
