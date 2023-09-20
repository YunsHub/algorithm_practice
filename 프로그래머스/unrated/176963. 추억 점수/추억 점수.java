import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> yearningMap = new HashMap<>();
        for(int index = 0; index < name.length; index++) {
            yearningMap.put(name[index], yearning[index]);
        }
        
        int answerIdx = 0;
        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                if(yearningMap.containsKey(photo[i][j])) sum += yearningMap.get(photo[i][j]);
            }
             answer[answerIdx++] = sum;
        }
        
        
        return answer;
    }
}