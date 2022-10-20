package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class id_1259 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word;
		boolean result;
		while(true) {
			word = br.readLine();
			result = true;
			
			if(word.equals("0")) {
				break;
			}
			
			for(int i = 0; i < word.length()/ 2; i++) {
				if(word.charAt(i) == word.charAt(word.length() - 1 - i)) {
					result = true;
				} else {
					result = false;
					break;
				}
			}
			
			if(result) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
			
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
