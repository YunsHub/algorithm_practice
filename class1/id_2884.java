package class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class id_2884 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());		
		
		if(minute < 45) {
			if(hour == 0) {
				hour = 23;
			} else {
				hour -= 1;
			}			
			minute = 60 + (minute - 45);
		} else {
			minute -= 45;
		}		
		bw.write(hour + " " + minute);
		
		br.close();
		bw.flush();
		bw.close();
	}

}
