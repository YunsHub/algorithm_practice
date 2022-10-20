package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class id_11050 {

	public static void main(String[] args) throws Exception {
		// 이항 계수 N K -- N! / K! * (N - K)!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = factorial(N) / (factorial(K) * factorial(N - K));
		bw.write(result + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int factorial(int N) {
		if(N < 1) {
			return 1;
		}
		
		return N * factorial(N - 1);
	}

}
