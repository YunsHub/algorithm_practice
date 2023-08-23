import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = false;    
        Stack<Character> stack = new Stack<>();
        for(int index = 0; index < s.length(); index++) {
            if(!stack.isEmpty()) {
                if(s.charAt(index) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(index));
                }
            } else {
                stack.push(s.charAt(index));
            }
        }
        if(stack.isEmpty()) {
            answer = true;
        }
        return answer;
    }
}