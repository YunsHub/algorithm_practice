import java.beans.BeanInfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 조합 공식 : nCr = n! / r! * (n-r)!
// 재귀 함수로 풀면 시간 초과가 발생한다.
// BigInteger를 사용한다.
// int 메모리 크기 : 4byte , 범위 : -2,147,483,648 ~ 2,147,483,647
// long 메모리 크기 : 8byte , 범위 : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
// 무한의 정수가 들어갈 가능성이 있다면 BigInteger 클래스를 활용한다.
// BigInteger는 문자열 형태로 이루어져 있어 숫자의 범위가 무한이다.
public class boj_2407 {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
// 5 2
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BigInteger num1 = BigInteger.valueOf(1);
        BigInteger num2 = BigInteger.valueOf(1);

        for(int i = 0; i < M; i++) {
            num1 = num1.multiply(new BigInteger(String.valueOf(N - i)));
            num2 = num2.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        System.out.println(num1.divide(num2));
        //System.out.println(comb(N, M));
    }

//    public static int comb(int n, int r) {
//        if (n == r || r == 0) {
//            return 1;
//        }
//        return comb(n - 1, r - 1) + comb(n - 1, r);
//    }
}
