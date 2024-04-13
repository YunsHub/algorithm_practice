import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[][] wheels = new char[4][8];
        for (int i = 0; i < 4; i++) {
            wheels[i] = br.readLine().toCharArray();
        }


        int M = Integer.parseInt(br.readLine());
        List<int[]> infoList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            infoList.add(new int[] {wheelNum-1, dir});
        }

        for(int[] info : infoList) {
            simulation(wheels, info[0], info[1]);
        }




        int answer = 0;
        int[] score = {1, 2, 4, 8};
        for (int i = 0; i < 4; i++) {
            if(wheels[i][0] == '1') {
                answer += score[i];
            }
        }
        System.out.println(answer);
    }

    public static void simulation(char[][] wheels, int wheelNum, int dir) {
        int[] rotate = new int[4];
        rotate[wheelNum] = dir;
        int number = 1;
        boolean left = true;
        boolean right = true;

        while(number < 4) {
            dir = -dir;
            if(wheelNum-number >= 0 && left) {
                if(wheels[wheelNum-number+1][6] != wheels[wheelNum-number][2]) {
                    rotate[wheelNum-number] = dir;
                } else {
                    left = false;
                }
            }

            if(wheelNum+number < 4 && right) {
                if(wheels[wheelNum+number-1][2] != wheels[wheelNum+number][6]) {
                    rotate[wheelNum+number] = dir;
                } else {
                    right = false;
                }
            }
            number++;
        }

        rotation(wheels, rotate);

    }

    public static void rotation(char[][] wheels, int[] rotate) {
        for (int i = 0; i < 4; i++) {
            if(rotate[i] == 0) continue;

            if(rotate[i] == 1) {
                moveRight(wheels[i]);
            } else {
                moveLeft(wheels[i]);
            }
        }
    }

    public static void moveLeft(char[] wheel) {
        char firstWheel = wheel[0];
        for (int i = 0; i < 7; i++) {
            wheel[i] = wheel[i+1];
        }
        wheel[7] = firstWheel;
    }

    public static void moveRight(char[] wheel) {
        char lastWheel = wheel[7];
        for (int i = 7; i > 0; i--) {
            wheel[i] = wheel[i-1];
        }
        wheel[0] = lastWheel;
    }
}
/*
10101111

01111101
11001110
00000010
2
3 -1
1 1
*/