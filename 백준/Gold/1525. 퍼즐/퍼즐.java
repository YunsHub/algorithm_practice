import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int bfs(int zeroIdx, int start){
        if(start == 123456780){
            return 0;
        }

        int result = 0;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{zeroIdx, start});
        visited.add(start);

        while(!q.isEmpty()){
            result++;
            for(int i = 0, size = q.size(); i < size; i++){
                int[] now = q.poll();
                int x = now[0] / 3;
                int y = now[0] % 3;
                for(int j=0; j<4; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx<0 || nx>=3 || ny<0 || ny>=3){ continue;}
                    int nextIdx = nx*3 + ny;
                    int next = swap(now[1], now[0], nextIdx);

                    if(next == 123456780){ return result;}
                    if(!visited.contains(next)){
                        visited.add(next);
                        q.add(new int[]{nextIdx, next});
                    }

                }
            }
        }
        return -1;
    }

    public static int swap(int num, int zeroIdx, int changeIdx){
        int lenIdx = 8;
        int su = (int)(num / Math.pow(10, lenIdx - changeIdx) % 10);
        num -= su * Math.pow(10, lenIdx - changeIdx);
        num += su * Math.pow(10, lenIdx - zeroIdx);
        return num;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int zeroIdx = 0, input = 0;
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 0){
                    zeroIdx = i*3 + j;
                }
                input = (input * 10) + num;
            }
        }

        System.out.println(bfs(zeroIdx, input));

    }
}