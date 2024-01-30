import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {    
        int answer = 0;
        // sort
        Arrays.sort(people);
        int start = 0, end = people.length-1;
        
        while(start <= end) {
            if(people[start] + people[end] <= limit) {                
                start++;
            }
            answer++;
            end--;
        }
        
        return answer;
    }
    
}

