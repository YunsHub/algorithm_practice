package class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class id_2908 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		//A = solve(A);
		//B = solve(B);
		
		if(A > B) {
			bw.write(A + "");
		} else {
			bw.write(B + "");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int solve(int num) {
		int num1 = num % 10;
		num /= 10;
		int num2 = num % 10;
		num /= 10;
		String nums = Integer.toString(num1) + Integer.toString(num2) + Integer.toString(num);
		num = Integer.parseInt(nums);
		return num;
	}

}
