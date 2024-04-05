import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {    
        int answer = 0;
        
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        
        while(start <= end) {
            if(people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            answer++;
        }
        return answer;
    }
    
}

