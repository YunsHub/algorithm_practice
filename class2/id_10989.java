package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class id_10989 {

	public static void main(String[] args) throws Exception {
		//1. Arrays sort 최악 : (O(n^2))
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int N = Integer.parseInt(br.readLine());
//		int[] num = new int[N];
//		
//		for(int i = 0; i < N; i++) {
//			num[i] = Integer.parseInt(br.readLine());
//		}
//		
//		Arrays.sort(num);
//		
//		for(int i = 0; i < N; i++) {
//			bw.write(num[i] + "\n");
//		}
//		
//		br.close();
//		bw.flush();
//		bw.close();
		//2. 카운팅 정렬 (O(N + K))
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		
		for(int i = 0; i < N; i++) {
			count[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 0; i < 10001; i++) {
			while(count[i] > 0) {
				sb.append(i).append("\n");
				count[i]--;
			}
		}
		
		System.out.println(sb);

	}

}
