import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int H;
	static int W;
	static int wall[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		wall = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			wall[i] = Integer.parseInt(st.nextToken());
		}
		
		int left;
		int right;
		int result =0;
		for(int i=1; i<W-1; i++) {
			left = 0;
			right = 0;
			// 왼쪽 벽 중 가장 높은 벽
			for(int j=i; j>=0; j--) {
				if(left<wall[j])
					left = wall[j];
			}
			// 오른쪽 벽 중 가장 높은 벽
			for(int j=i; j<W; j++) {
				if(right<wall[j])
					right = wall[j];
			}
			result += Math.min(left, right)-wall[i];
			
		}
		System.out.println(result);
	}
}