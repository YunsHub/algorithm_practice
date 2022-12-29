import java.util.Scanner;

public class boj1747 {
    static int N;
    static final int MAX = 1_004_000;
    static boolean[] isPrime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        isPrime = new boolean[MAX+1];
        isPrime[1] = true;
        prime();

    }

    public static void prime() {
        for(int i = 2; i <= MAX ; i++) {
            if(isPrime[i]){continue;}
            if(i>=N && solve(i)){
                System.out.println(i);
                return;
            }
            for(int j=i+i; j <= MAX; j+=i){
                isPrime[j] = true;
            }
        }
    }

    public static boolean solve(int num) {
        if(num < 10) {
            return true;
        }
        String str = String.valueOf(num);
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() -1 - i)) {
                return false;
            }
        }
        return true;
    }
}
