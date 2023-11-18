import java.util.*;
class Solution {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!check(s, i)) continue;
            String num = "";
            int index = i;
            while(check(s, index)) {
                num += s.charAt(index);
                index++;
            }
            i = index;
            int tuple = Integer.parseInt(num);
            map.put(tuple, map.getOrDefault(tuple, 0)+1);
        }
        
        int size = map.size();
        int[] arr = new int[size];
        
        for(int key : map.keySet()) arr[map.get(key) - 1] = key;
        int[] answer = new int[size];
    
        int answerIdx = 0;
        for(int i = arr.length - 1; i >=0; i--) answer[answerIdx++] = arr[i];
        
        return answer;
    }
    
    public boolean check(String s, int index) {
        char word = s.charAt(index);
        if(word == '{' || word == '}' || word == ',') return false;
        return true;
    }
}