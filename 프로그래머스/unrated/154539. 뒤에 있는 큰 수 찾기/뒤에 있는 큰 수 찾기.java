import java.util.*;
class Solution {
    public class Number {
        int index = 0;
        int number = 0;
        public Number(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
    // 2 3 2 3 5
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Number> stack = new Stack<>();        
        for(int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && stack.peek().number < numbers[i]) {
                Number number = stack.pop();
                answer[number.index] = numbers[i];              
            } 
            stack.push(new Number(i, numbers[i]));
        }
        
        return answer;        
    }
}