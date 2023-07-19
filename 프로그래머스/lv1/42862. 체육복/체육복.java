import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] student = new int[n];
        for(int index : lost) {
            student[index - 1]--;
        }
        for(int index : reserve) {
            student[index - 1]++;
        }
        for(int index = 0; index < n; index++) {
            if(student[index] == -1) {
                if(index - 1 >= 0 && student[index - 1] == 1) {
                    student[index]++;
                    student[index - 1]--;
                } else if(index + 1 < n && student[index + 1] == 1) {
                    student[index]++;
                    student[index + 1]--;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}