import java.util.*;

class Solution {    
    // 스택 활용
    // stack.get() 사용

    // ArrayList 활용
    
    // Array 활용    
    public int solution(int[] ingredient) {
        int answer = 0;            
//         Stack<Integer> stack = new Stack<>();
        
//         for(int i=0; i<ingredient.length; i++) {        
//             int food = ingredient[i];
//             stack.add(food);
            
//             if(stack.size() >= 4 && food == 1) {
//                 int size = stack.size()-1;
//                 if(stack.get(size-1)==3&&stack.get(size-2)==2&&stack.get(size-3)==1) {
//                     answer++;
//                     for(int j=0; j<4; j++) {
//                         stack.pop();
//                     }
//                 } 
                
//             } 
//         }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int food : ingredient) {
            list.add(food);
            if(list.size() >= 4 && food == 1) {
                int size = list.size() - 1;
                if(list.get(size-1)==3 && list.get(size-2)==2&&list.get(size-3)==1) {
                    for(int i=0; i<4; i++) {
                        list.remove(list.size()-1);
                    }
                    answer++;
                }
            }
        }
        
        return answer;
    }
}