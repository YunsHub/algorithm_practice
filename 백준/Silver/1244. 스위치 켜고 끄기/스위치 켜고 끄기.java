import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//스위치 켜고 끄기
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int N = Integer.parseInt(br.readLine());
		int[] status = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			status[i] = Integer.parseInt(st.nextToken());
		}
		int studentNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int statusNum = Integer.parseInt(st.nextToken());
			int first = statusNum - 1;
			if(gender == 1) {	//남자
				for(int j = first; j < N; j += statusNum) {
					status[j] = status[j] == 1 ? 0 : 1;  
				}
			}
			else if(gender == 2) {	//여자
				status[first] = status[first] == 1 ? 0 : 1;
				int count = 1;
				while(first + count < N && first - count >= 0) {
					if(status[first + count] != status[first - count]) {
						break;
					} else {
						count++;
					}
				}
				for(int j = 1; j < count; j++) {
					status[first + j] = status[first + j] == 1 ? 0 : 1;
					status[first - j] = status[first - j] == 1 ? 0 : 1;
				}
			}
		}
		for(int i = 0; i < status.length; i++) {
			if(i % 20 == 0 && i > 0) {
				System.out.println();
			}
			System.out.print(status[i] + " ");			
		}
	}
}
