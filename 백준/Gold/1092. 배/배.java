import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] crane = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int[] box = new int[1000001];

        st = new StringTokenizer(br.readLine());

        TreeSet<Integer> numberSet = new TreeSet<>();
        int max = 0;
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            box[num]++;
            max = Math.max(max, num);
            numberSet.add(num);
        }

        Arrays.sort(crane);

        if(crane[crane.length - 1] < max){ // 종료 조건 -> crane이 box를 옮기지 못하는 경우
            System.out.println(-1);
            return;
        }

        int total = 0; // 몇 개 했는지 판단
        int result = 0;

        while(total < M){ // M번 처리하면 종료
            for(int i = 0; i < N; i++){
                int limit = crane[i];
                if(numberSet.floor(limit) == null) continue;
                int num = numberSet.floor(limit); // treeset에서 crane값보다 같거나 작은 num을 뽑음
                while(true) {
                    if(box[num] == 0){ // num이 0인 경우 (그 전에 미리 처리한 경우)
                        numberSet.remove(num); // num이 0이면 treeSet에서 없애준다 (처리해주지 않으면 계속 내려가는 최악의 경우가 생길것)
                        if(numberSet.lower(num) == null) break;
                        num = numberSet.lower(num); // num보다 작은 다음 값을 treeset에서 다시 뽑아줌
                        continue;
                    }

                    box[num]--;  // 카운팅 배열 box의 카운트를 하나 줄여줌
                    total++;
                    break;
                }
            }
            result++;  // crane을 한번 돌면 1초 증가
        }

        System.out.println(result);
        br.close();
    }
}