import java.util.*;
class Solution {
    public static int[][] map;
    public static int min;
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int num = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        int[] answer = new int[queries.length];
        int idx = 0;
        for(int i = 0; i < queries.length; i++) {
            int minX = queries[i][0] - 1;
            int minY = queries[i][1] - 1;
            int maxX = queries[i][2] - 1;
            int maxY = queries[i][3] - 1;
            
            answer[idx++] = rotate(minX, minY, maxX, maxY);
        }
        
        
        return answer;
    }
    
    public int rotate(int minX, int minY, int maxX, int maxY) {
        int temp = map[minX][maxY];
        min = temp;
        for(int i = maxY; i > minY; i--) {
            map[minX][i] = map[minX][i - 1];
            min = Integer.min(min, map[minX][i]);
        }
        
        for(int i = minX; i < maxX; i++) {
            map[i][minY] = map[i + 1][minY];
            min = Integer.min(min, map[i][minY]);
        }
        
        for(int i = minY; i < maxY; i++) {
            map[maxX][i] = map[maxX][i + 1];
            min = Integer.min(min, map[maxX][i]);
        }
        
        for(int i = maxX; i > minX + 1; i--) {
            map[i][maxY] = map[i - 1][maxY];
            min = Integer.min(min, map[i][maxY]);
        }
        map[minX + 1][maxY] = temp;
        
        return min;
    }
}
 