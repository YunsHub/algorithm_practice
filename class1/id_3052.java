package class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class id_3052 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] num = new int[10];
		int cnt  = 10;
		
		for(int i = 0; i < 10; i++) {
			num[i] = Integer.parseInt(br.readLine()) % 42;
			if(i > 0) {
				for(int j = i - 1; j >= 0; j--) {
					if(num[i] == num[j]) {
						cnt--;
						break;
					}
				}
			}
		}
		bw.write(cnt + "\n");		
		br.close();
		bw.flush();
		bw.close();			
	}

}
