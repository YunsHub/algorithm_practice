import java.util.*;

class Solution {
        
    String[] wordOrder = {"A", "E", "I", "O", "U"};
    Map<Character, Integer> wordMap;

    public int solution(String word) {
        StringBuilder sb = new StringBuilder();        
        wordMap = new HashMap<>();
        
        for(int i=0; i<wordOrder.length; i++) {
            wordMap.put(wordOrder[i].charAt(0), i);
        }
        
        int answer = permutation(sb, 0, 0, word);
        
        return answer;
    }
    
    public int permutation(StringBuilder sb, int depth, int len, String word) {
        if(sb.toString().equals(word) ) {
            return depth;
        }
        
        if(len == 5) {
            while(sb.toString().charAt(len-1) == 'U') {
                sb.deleteCharAt(--len);
            }
            sb.replace(len-1, len-1, wordOrder[(wordMap.get((sb.toString().charAt(len-1))) + 1) % 5]);
            sb.deleteCharAt(len);
        } else {
            sb.append(wordOrder[0]);
        }
        
        return permutation(sb, depth+1, sb.length(), word);
    }
}