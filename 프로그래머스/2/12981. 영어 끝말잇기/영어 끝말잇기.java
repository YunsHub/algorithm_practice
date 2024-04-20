import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int fail = 0;
        char lastWord = words[0].charAt(0);
        
        for(int i=0; i<words.length; i++) {
            if(map.containsKey(words[i])
               || lastWord != words[i].charAt(0)
               || words[i].length() == 1
              ){
                fail = i;
                break;                
            } else {
                map.put(words[i], 1);
            }
            
            lastWord = words[i].charAt(words[i].length()-1);
        }

        int[] answer = new int[2];
        if(fail == 0) answer = new int[] {0, 0};
        else answer = new int[] {fail%n+1 , fail/n+1};
        return answer;
    }
}