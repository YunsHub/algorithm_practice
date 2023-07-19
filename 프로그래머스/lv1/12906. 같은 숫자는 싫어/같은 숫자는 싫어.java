import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> number = new Stack<>();
        for(int index = 0; index < arr.length; index++) {
            if(!number.isEmpty() && number.peek() == arr[index]) continue;
            number.push(arr[index]);
        }
        int idx = number.size() - 1;
        int[] answer = new int[number.size()];
        while(!number.isEmpty()) {
            answer[idx--] = number.pop();
        }

        return answer;
    }
}