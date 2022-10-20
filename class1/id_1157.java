package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class id_1157 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int[] arr = new int[26];
		
		int max = -1;
		char st = '?';
		
		for(int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 65]++;
			if(max < arr[str.charAt(i) - 65]) {
				max = arr[str.charAt(i) - 65];
				st = str.charAt(i);
			}
			else if(max == arr[str.charAt(i) - 65]) {
				st = '?';
			}
		}
		System.out.println(st);
		
		
	}

}
