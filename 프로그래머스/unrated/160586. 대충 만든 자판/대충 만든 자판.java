import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];
        
        for(String key : keymap) {
            for(int i=0 ; i<key.length() ; i++) {
                char word = key.charAt(i);
                if(!map.containsKey(word) || i < map.get(word)) {
                    map.put(word, i+1);
                }
            }
        }
        
        for(int i=0 ; i<targets.length ; i++) {
            int cnt = 0;
            for(int j=0 ; j<targets[i].length() ; j++) {
                char word = targets[i].charAt(j);
                if(!map.containsKey(word)) {
                    cnt = 0;
                    break;
                } else {
                    cnt += map.get(word);
                }
            }
            answer[i] = cnt==0?-1:cnt;
        }
        return answer;
    }
}