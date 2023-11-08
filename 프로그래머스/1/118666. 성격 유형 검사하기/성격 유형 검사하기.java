import java.util.*;

class Solution {
    
    public static HashMap<Character, Integer> map;
    
    public String solution(String[] survey, int[] choices) {        
        map = new HashMap<>();        
        init(survey, choices); 
        
        return result();
    }
    
    public static String result() {
        StringBuilder sb = new StringBuilder();
        
        if(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) sb.append("R");
        else sb.append("T");
        
        if(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) sb.append("C");
        else sb.append("F");
        
        if(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) sb.append("J");
        else sb.append("M");
        
        if(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) sb.append("A");
        else sb.append("N");
        
        return sb.toString();
    }
    
    public static void init(String[] survey, int[] choices) {
        
        for(int i = 0; i < survey.length; i++) {
            String str = survey[i];            
            if(choices[i] < 4) {
                char word = str.charAt(0);
                map.put(word, map.getOrDefault(word, 0) + 4 - choices[i]);
            } 
            else {
                char word = str.charAt(1);
                map.put(word, map.getOrDefault(word, 0) + (choices[i] % 4));
            }
        }
    }
}