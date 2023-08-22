import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {            
            for(int j = i; j < i + s.length(); j++) {
                char bracket = s.charAt(j % s.length());
                if(!stack.isEmpty()) {
                    char compare = stack.peek();
                    if(bracket == ')' && compare == '(') {
                        stack.pop();    
                    } else if(bracket == ']' && compare == '[') {
                        stack.pop();
                    } else if(bracket == '}' && compare == '{'){
                        stack.pop();
                    } else {
                        stack.push(bracket);
                    }
                } else {
                    stack.push(bracket);    
                }                
            }
            if(stack.isEmpty()) answer++;
            stack.clear();
         }
        
        
        
        return answer;
    }
}