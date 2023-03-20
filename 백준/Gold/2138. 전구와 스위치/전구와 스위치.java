import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static String nowState, resultState;
    static boolean[] onlight, offlight, resultLight;
    static int onClick, offClick;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nowState = br.readLine();
        resultState = br.readLine();
        onlight = new boolean[N];
        offlight = new boolean[N];
        resultLight = new boolean[N];

        for(int i = 0; i < N; i++) {
            onlight[i] = nowState.charAt(i) == '0' ? false : true;
            offlight[i] = nowState.charAt(i) == '0' ? false : true;
            resultLight[i] = resultState.charAt(i) == '0' ? false : true;
        }

        click();

        if(onClick == Integer.MAX_VALUE && offClick == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(onClick, offClick));
        }

    }

    public static void click() {
        onClick = 1;
        offClick = 0;
        onlight[0] = !onlight[0];
        onlight[1] = !onlight[1];
        for(int i = 1; i < N; i++) {
            if(onlight[i - 1] != resultLight[i - 1]) {
                onlight[i - 1] = !onlight[i - 1];
                onlight[i] = !onlight[i];
                if(i + 1 < N) {
                    onlight[i + 1] = !onlight[i + 1];
                }
                onClick++;
            }

            if(offlight[i - 1] != resultLight[i - 1]) {
                offlight[i - 1] = !offlight[i - 1];
                offlight[i] = !offlight[i];
                if(i + 1 < N) {
                    offlight[i + 1] = !offlight[i + 1];
                }
                offClick++;
            }
        }

        if(!Arrays.equals(onlight, resultLight)) {
            onClick = Integer.MAX_VALUE;
        }
        if(!Arrays.equals(offlight, resultLight)) {
            offClick = Integer.MAX_VALUE;
        }
    }
}