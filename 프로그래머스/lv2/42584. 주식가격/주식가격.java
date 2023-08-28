import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // for(int index = 0; index <prices.length - 1; index++) {
        //     for(int num = index + 1; num <prices.length; num++) {
        //         answer[index]++;
        //         if(prices[index] > prices[num]) break;    
        //     }
        // } 
        
        Stack<Integer> stack = new Stack<>();
        for(int index = 0; index < prices.length; index++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[index]) {
                answer[stack.peek()] = index - stack.peek();
                stack.pop();
            }
            stack.push(index);
        }
        
        
        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - 1 - stack.peek();
            stack.pop();
        }
        
        return answer;
    }
}