import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str, "0");
        StringTokenizer st2 = new StringTokenizer(str, "1");
        System.out.println(Math.min(st1.countTokens(), st2.countTokens()));
    }
}