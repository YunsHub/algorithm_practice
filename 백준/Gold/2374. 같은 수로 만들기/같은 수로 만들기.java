import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);
            if(stack.isEmpty()) {   // 스택이 비어있을 경우 숫자 추가
                stack.push(num);
            } else{
                int top = stack.peek();
                if(top < num) {
                    result += num - top;
                }
                stack.pop();
                stack.push(num);
            }

        }

        while(!stack.isEmpty()) {
            long x = stack.pop();
            result += max-x;
        }

        System.out.println(result);
    }
}