package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class id_1929 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] result = new boolean[N + 1];
		
		for(int i = 2; i <= N; i ++) {
			if(result[i]) {
				continue;
			}
			if(i >= M) {
				bw.write(i + "\n");
			}
			for(int j = i + i; j <= N; j+= i) {
				result[j] = true;
			}
			
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
