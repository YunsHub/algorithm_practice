import java.util.*;
import java.io.*;

class Main
{
    static int DIR_NUM = 4;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;

    public static class Snake {
        int x;
        int y;
        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static class DirInfo {
        int time;
        char dir;
        public DirInfo(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];

        int appleNum = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < appleNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = true;
        }

        int dirNum = Integer.parseInt(br.readLine());
        ArrayList<DirInfo> dirList = new ArrayList<>();
        for (int i = 0; i < dirNum; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            dirList.add(new DirInfo(time, dir));
        }

        int answer = 0;
        int nowDir = 0;
        int prevTime = 0;
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        Deque<Snake> deque = new LinkedList<>();
        deque.add(new Snake(0, 0));

        int index = 1;
        int t = dirList.get(0).time;
        char d = dirList.get(0).dir;
        while (true) {
            answer++;

            Snake snake = deque.peek();
            int nx = snake.x + dx[nowDir];
            int ny = snake.y + dy[nowDir];

            if (!isRange(nx, ny) || visited[nx][ny]) break;

            deque.addFirst(new Snake(nx, ny));
            visited[nx][ny] = true;
            if (!map[nx][ny]) {
                Snake tail = deque.pollLast();
                visited[tail.x][tail.y] = false;
            } else {
                map[nx][ny] = false;
            }


            if (answer == t) {
                if (d == 'D') {
                    nowDir = (nowDir + 1) % 4;
                } else {
                    nowDir = (nowDir + 3) % 4;
                }

                if (index < dirList.size()) {
                    t = dirList.get(index).time;
                    d = dirList.get(index).dir;
                    index++;
                }
            }

        }

        System.out.println(answer);
    }

    public static boolean isRange(int x, int y) {
        return x>=0 && y>=0 && x<N&& y<N;
    }

}