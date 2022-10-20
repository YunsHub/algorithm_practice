package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class id_2231 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
//		int count = N;
//		int min = 0;
//		while(count > 0) {
//			int value = count;
//			int rest = 0;
//			while(value / 10 != 0) {
//				rest += (value % 10);
//				value /= 10;	
//			}
//			rest += value;
//			
//			if(N == (rest + count)) {
//				min = count;
//			}
//			count--;
//		}
//		bw.write(min + "");
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			int number = i;
			int sum = 0;	// 각 자릿수 합 변수 
			
			while(number != 0) {
				sum += number % 10;	// 각 자릿수 더하기
				number /= 10;
			}
			
			// i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우) 
			if(sum + i == N) {
				result = i;
				break;
			}
		}	
		bw.write(result + "");
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
