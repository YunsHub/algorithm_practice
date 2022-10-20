package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class id_2292 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int num = 1;
		int i = 1;
		while(true) {
			if(num < N) {
				num += 6 * i;
				i++;
			} else {
				break;
			}
			
		}
		bw.write(i + "");
		br.close();
		bw.flush();
		bw.close();
	}

}
