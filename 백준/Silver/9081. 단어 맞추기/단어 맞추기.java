import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 처음엔 모든 조합을 구하고 해당 문자 다음 걸 출력해보는 방식으로 구현했는데 시간 초과가 나서
// 기준 문자열에서만 비교해서 다음 문자가 올 값을 정하는 방식으로 생각하였다.
// 찾은 규칙으로는 뒤에서부터 탐색해 앞으로 오면서 현재값보다 작은값 min을 찾는다. (찾지 못할 경우 그대로 출력)
// 다시 뒤에서부터 min보다 큰 값 max를 찾고 min과 max의 값을 바꿔주고 min부터 마지막까지 정렬해준다.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {
            String str = br.readLine();
            int length = str.length();
            char[] word = new char[length];

            for(int i = 0; i < length; i++) {
                word[i] = str.charAt(i);
            }

            int min = 0;
            int minIdx = -1;
            int maxIdx = 0;
            loop: for(int i = length - 1; i > 0; i--) {
                    if(word[i] > word[i - 1]) {
                        min = word[i - 1];
                        minIdx = i - 1;
                        break loop;
                    }
            }

            if(minIdx == -1) {
                sb.append(str).append("\n");
            } else{
                for(int i = length - 1; i >= 0; i--) {
                    if(word[i] > min) {
                        maxIdx = i;
                        break;
                    }
                }

                char temp = word[minIdx];
                word[minIdx] = word[maxIdx];
                word[maxIdx] = temp;

                Arrays.sort(word, minIdx + 1, length);

                for(char result : word) {
                    sb.append(result);
                }
                sb.append("\n");
            }


        }
        System.out.println(sb);
    }
}