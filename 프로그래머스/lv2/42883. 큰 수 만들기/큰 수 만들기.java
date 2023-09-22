import java.util.*;
class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++) {
            char num = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < num && k-- > 0) {
                stack.pop();
            }
            stack.push(num);            
        }
        while(k-- > 0) {
                stack.pop();
            }
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
        // for (int i=0; i<result.length; i++) {
        //     result[i] = stack.get(i);
        // }
        // return new String(result);
//         StringBuilder sb = new StringBuilder();
//         int index = 0;
        
//         for(int i = 0; i < number.length() - k; i++) {
//             int max = 0;
//             for(int j = index; j < k + i + 1 ; j++) {
//                 if(max < number.charAt(j) - '0') {
//                     max = number.charAt(j) - '0';
//                     index = j + 1;
//                 }
//             }
//             sb.append(max);
//         }
        
//         return sb.toString();
    }
}