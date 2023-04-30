import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                s.pop();
            } else {
                s.push(num);
            }
        }
        int result = 0;
        while (!s.isEmpty()) {
            result += s.pop();
        }
        System.out.println(result);

    }
}