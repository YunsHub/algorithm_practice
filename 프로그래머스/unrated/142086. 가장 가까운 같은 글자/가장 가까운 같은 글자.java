import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int index = 0;
        int[] word = new int[26];
        for(char c : s.toCharArray()) {
            int num = word[c - 'a'];
            if(num == 0) {                
                answer[index++] = -1;
            } else {                
                answer[index++] = index - num;
            }
            word[c - 'a'] = index;
        }
        
        return answer;
    }
}