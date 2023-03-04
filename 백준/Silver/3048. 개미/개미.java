import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Ant {
        char name;
        int dir;
        Ant(char name, int dir) {
            this.name = name;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        ArrayList<Ant> list = new ArrayList<>();
        String str1 = br.readLine();
        String str2 = br.readLine();
        for(int i = N1 - 1; i >= 0; i--) {
            list.add(new Ant(str1.charAt(i), 1));
        }

        for(int i = 0; i < N2; i++) {
            list.add(new Ant(str2.charAt(i), 2));
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            for(int i = 0; i < list.size() - 1; i++) {
                if(list.get(i).dir == 1 && list.get(i + 1).dir == 2) {
                    char antName = list.get(i).name;
                    int antDir = list.get(i).dir;
                    list.get(i).name = list.get(i + 1).name;
                    list.get(i).dir = list.get(i + 1).dir;
                    list.get(i + 1).name = antName;
                    list.get(i + 1).dir = antDir;
                    i++;
                }
            }
        }

        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).name);
        }
        System.out.println(sb);
    }
}