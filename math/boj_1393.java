import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1393 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int nx = Integer.parseInt(st.nextToken());
        int ny = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());


        int mok = gcd(dx, dy);
        dx /= mok;
        dy /= mok;

        int min = Integer.MAX_VALUE;
        int mx = nx;
        int my = ny;

        while (Math.abs(nx) <= 100 && Math.abs(ny) <= 100) {
            int distance = (int)(Math.pow(x - nx, 2) + Math.pow(y - ny, 2));
            if(min > distance) {
                mx = nx;
                my = ny;
                min = distance;
            }
            nx += dx;
            ny += dy;
        }

        System.out.println(mx + " " +my);

    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
