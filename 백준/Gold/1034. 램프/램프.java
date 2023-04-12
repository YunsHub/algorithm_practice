import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int K = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i = 0; i < N; i++){
            int zeroCount = 0; // 0의 개수
            for(int j = 0; j < M; j++){ // 행의 0의 개수 구하기
                if(arr[i][j] == '0'){
                    zeroCount++;
                }
            }

            // 짝수 판별, zero 몇개인지
            // 0이 K보다 크면 램프를 모두 킬 수 없음
            // K 나머지, 0 나머지가 같아야 모두 1로 만들 수 있다?
            if(zeroCount <= K && K % 2 == zeroCount % 2){
                int count = 0;
                for(int j = 0; j < N; j++){
                    if(isEqaulArr(arr[i], arr[j])){ // 다른 행의 j번 인덱스와 같으면 스위치가 모두 켜져있는 행
                        count++;
                    }
                }

                result = Math.max(result, count);
            }
        }

        System.out.println(result);
    }

    public static boolean isEqaulArr(char[] a, char[] b){

        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

}