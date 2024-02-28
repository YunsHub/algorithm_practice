import java.util.*;

class Solution {    
    // 스택 활용
    // stack.get() 사용

    // 배열 활용
    public int solution(int[] ingredient) {
        int answer = 0;            
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<ingredient.length; i++) {        
            int food = ingredient[i];
            stack.add(food);
            
            if(stack.size() >= 4 && food == 1) {
                int size = stack.size()-1;
                if(stack.get(size-1)==3&&stack.get(size-2)==2&&stack.get(size-3)==1) {
                    answer++;
                    for(int j=0; j<4; j++) {
                        stack.pop();
                    }
                } 
                
            } 
        }
        
        return answer;
    }
}