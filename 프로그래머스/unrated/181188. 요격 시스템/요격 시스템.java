import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int last = targets[0][1];
        for(int[] target : targets) {
            if(target[0] >= last) {
                answer++;
                last = target[1];
            }
        }
    
        return answer;
    }
}