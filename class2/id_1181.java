package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class id_1181 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();					
		}
		
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
	}

}
