import java.util.Scanner;

public class boj1475 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        String input = sc.nextLine();
        for(int i=0; i<input.length(); i++){
            arr[input.charAt(i)-'0']++;
        }

        int res = 0;
        arr[6] = (arr[6]+arr[9]+1)/2;
        for(int i=0; i<=8; i++){
            res = Math.max(arr[i], res);
        }
        System.out.println(res);
    }
}
