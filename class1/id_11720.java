package class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class id_11720 {

	public static void main(String[] args) throws Exception{
		// 1번
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br.readLine();	// N 은 쓸모가 없으므로 입력만 받는다.
//		
//		int sum = 0;
//		
//		for(byte value : br.readLine().getBytes()) {
//			sum += (value - '0');	
//		}
//		
//		System.out.print(sum);
		
		// 2번
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String num = br.readLine();
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			sum += num.charAt(i) - '0';
		}
		bw.write(sum + "");
		br.close();
		bw.flush();
		bw.close();
	}

}
