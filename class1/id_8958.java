package class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class id_8958 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int score = 0;
			int cnt = 1;
			String[] str = br.readLine().split("");
			for(int i = 0; i < str.length; i++) {
				if(str[i].equals("O")) {
					score += cnt;
					cnt++;
				} else {
					cnt = 1;
				}
			}
			bw.write(score + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
