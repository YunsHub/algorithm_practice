import java.util.*;
class Solution {
    public static int[][] map;
    public static int[][] base;
    public static int min;
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        base = new int[rows][columns];
        int num = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        int[] answer = new int[queries.length];
        int idx = 0;
        for(int i = 0; i < queries.length; i++) {
            copyArray();
            min = Integer.MAX_VALUE;
            int minX = queries[i][0] - 1;
            int minY = queries[i][1] - 1;
            int maxX = queries[i][2] - 1;
            int maxY = queries[i][3] - 1;
            rightArrow(minX, minY + 1, maxY);
            downArrow(minX + 1, maxY, maxX);
            leftArrow(maxX, maxY - 1, minY);
            topArrow(maxX - 1, minY, minX);
            //System.out.println(Arrays.deepToString(base));
            answer[idx++] = min;
        }
        
        
        return answer;
    }
    public void rightArrow(int x, int y, int newY) {
        for(int i = y; i <= newY; i++) {
            map[x][i] = base[x][i - 1];
            min = Integer.min(min, map[x][i]);
        }
    }
    public void downArrow(int x, int y, int newX) {
        for(int i = x; i <= newX; i++) {
            map[i][y] = base[i - 1][y];
            min = Integer.min(min, map[i][y]);
        }
    }
    public void leftArrow(int x, int y, int newY) {
        for(int i = y; i >= newY; i--) {
            map[x][i] = base[x][i + 1];
            min = Integer.min(min, map[x][i]);
        }
    }
    public void topArrow(int x, int y, int newX) {
        for(int i = x; i >= newX; i--) {
            map[i][y] = base[i + 1][y];
            min = Integer.min(min, map[i][y]);
        }
    }
    
    public static void copyArray() {
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++){
                base[i][j] = map[i][j];
            }
        }
    }
}