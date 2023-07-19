import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int idx = 0;
        int[] answer = new int[commands.length];
        for(int index = 0; index < commands.length; index++) {
            int first = commands[index][0] - 1;
            int last = commands[index][1];
            int select = commands[index][2] - 1;
            int[] temp = Arrays.copyOfRange(array, first, last);                        
            Arrays.sort(temp);
            answer[idx++] = temp[select];
        }
        
        return answer;
            
            
    }
}