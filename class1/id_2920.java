package class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class id_2920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		for(int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int i = 0;
		while(true) {
			if(arr[i] + 1 == arr[i + 1]) {
				if(i == 6) {
					bw.write("ascending");
					break;
				}
				i++;
			}
			else if(arr[i] - 1 == arr[i + 1]) {
				if(i == 6) {
					bw.write("descending");
					break;
				}
				i++;
			} else {				
				bw.write("mixed");
				break;
			}
		}
		br.close();
		bw.flush();
		bw.close();
		

	}

}
