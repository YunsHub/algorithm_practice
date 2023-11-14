import java.util.*;

class Solution {
    
    static long answer = 0;
    static char[] op = new char[3];
    static boolean[] visited= new boolean[3];
    
    public long solution(String expression) {        
        
        permutation(expression, "+-*", 0, 0);
        return answer;
    }
    
    public long calculation(int idx, String expression) {
        if(idx > 2) {
            return Integer.parseInt(expression);
        }
        
        StringTokenizer st = new StringTokenizer(expression, String.valueOf(op[idx]));
        
        long temp = calculation(idx + 1, st.nextToken());
        
        while(st.hasMoreTokens()) {
            long num = calculation(idx + 1, st.nextToken());
            switch(op[idx]){
                    case '+' -> temp += num;
                    case '-' -> temp -= num;
                    case '*' -> temp *= num;
            }
        }    
        
        return temp;        
    }
    
    public void permutation(String expression, String ops, int idx, int cnt) {
        if(cnt == 3) {
            long temp = Math.abs(calculation(0, expression));
            answer = Math.max(answer, temp);
            return;
        }
        for(int i = 0; i < ops.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                op[cnt] = ops.charAt(i);
                permutation(expression, ops, idx + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
}