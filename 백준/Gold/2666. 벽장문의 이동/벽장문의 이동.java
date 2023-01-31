import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, M, result;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] opened = br.readLine().split(" ");
        int left = Integer.parseInt(opened[0]);
        int right = Integer.parseInt(opened[1]);

        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        result = Integer.MAX_VALUE;
        dfs(0, left, right, 0);
        System.out.println(result);
    }

    public static void dfs(int idx, int l, int r, int sum){
        if(result <= sum){
            return;
        }
        if(idx == M){
            result = sum;
            return;
        }

        if(l==arr[idx] || r == arr[idx]){
            dfs(idx+1, l, r, sum);
        }
        else if(l < arr[idx] && arr[idx] < r){
            dfs(idx+1, arr[idx], r, sum + arr[idx] - l);
            dfs(idx+1, l, arr[idx], sum + r - arr[idx]);
        }
        else if(arr[idx] < l){
            dfs(idx+1, arr[idx], r, sum + l - arr[idx]);
        }
        else {
            dfs(idx+1, l, arr[idx], sum + arr[idx] - r);
        }
    }

}