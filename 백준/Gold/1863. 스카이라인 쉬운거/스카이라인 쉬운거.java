import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] height = new int[N + 1];
        Stack<Integer> building = new Stack<>();

        for(int i = 0; i <= N; i++) {
            if(i != N) {
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                height[i] = y;
            }
            while (!building.isEmpty() && building.peek() > height[i]) {
                result++;
                building.pop();
            }
            if (building.isEmpty() || building.peek() != height[i]) {
                building.add(height[i]);
            }
        }

        System.out.println(result);

    }
}