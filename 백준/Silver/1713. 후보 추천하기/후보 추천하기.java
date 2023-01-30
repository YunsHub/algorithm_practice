import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] star = new int[101]; //추천 받은 횟수
        int[] regtime = new int[101]; //게시된 시간
        int[] picture = new int[N]; // 게시된 후보 번호
        int size = 0;

        Arrays.fill(regtime, 1001);
        Arrays.fill(picture, 101);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isExist = false;
            for(int j = 0; j < size; j++){
                if(picture[j] == num){
                    isExist = true;
                }
            }

            if(!isExist){
                if(size == N){
                    int minTime = 1001, minValue = 1001, idx = 0;
                    for(int j = 0; j < size; j++){
                        if(star[picture[j]] > minValue){
                            continue;
                        }
                        if(star[picture[j]] == minValue && regtime[picture[j]] > minTime){
                            continue;
                        }
                        minValue = star[picture[j]];
                        minTime = regtime[picture[j]];
                        idx = j;
                    }
                    star[picture[idx]] = 0;
                    picture[idx] = num;
                    regtime[num] = i;
                }
                else{
                    picture[size++] = num;
                    regtime[num] = i;
                }
            }

            star[num]++;

        }

        Arrays.sort(picture);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append(picture[i]).append(" ");
        }
        System.out.println(sb);

    }
}