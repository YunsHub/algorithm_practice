import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] skipWord = new boolean[26];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < skip.length(); i++) {
            int word = skip.charAt(i) - 'a';
            skipWord[word] = true;
        }
        
        for(int i = 0; i < s.length(); i++) {
            int word = s.charAt(i) - 'a';
            int cnt = 0;
            while(true) {
                if(cnt == index) break;
                word = (word + 1) % 26;
                if(skipWord[word]) continue;                
                cnt++;
            }
            char pass = (char) (word + 'a');
            sb.append(pass);
        }
        return sb.toString();
    }
}