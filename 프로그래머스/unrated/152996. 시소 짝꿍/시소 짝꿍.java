import java.util.*;
class Solution {
    public long solution(int[] weights) {        
        long answer = 0;
        long[] arr = new long[1_001];
        for(int weight : weights) arr[weight]++;
        Arrays.sort(weights);
        for(int i = 0; i < weights.length; i++) {
            // 1배 4/3배 1.5배 2배 (몸무게는 정수)
            if(weights[i] * 2 < 1001 && arr[weights[i] * 2] > 0) answer += arr[weights[i] * 2];
            if((weights[i] / 2) * 3 < 1001 && weights[i] % 2 == 0 
               && arr[(weights[i] / 2) * 3] > 0) answer += arr[(weights[i] / 2) * 3];            
            if((weights[i] / 3) * 4 < 1001 &&weights[i] % 3 == 0 
               && arr[(weights[i] / 3) * 4] > 0) answer += arr[(weights[i] / 3) * 4];
            if(arr[weights[i]] > 1) {
                answer += (arr[weights[i]] * (arr[weights[i]] - 1)) / 2;
                arr[weights[i]] = 0;
            }
            //System.out.println(answer + " " + weights[i] +" " + arr[weights[i]]);
        }
        
        return answer;
    }
}