import java.util.*;
class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static boolean check = false;
    static boolean check2 = false;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        arr = new int[maps.length][maps[0].length()];    
        
        int x = 0;
        int y = 0;
        int exitX = 0;
        int exitY = 0;
        int leberX = 0;
        int leberY = 0;
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j)=='S') {
                    x = i;
                    y = j;
                }
                else if(maps[i].charAt(j)=='E') {
                    exitX = i;
                    exitY = j;
                }
                else if(maps[i].charAt(j)=='L') {
                    leberX = i;
                    leberY = j;
                }
            }
        }
        
        visited = new boolean[maps.length][maps[0].length()];
        bfs(x, y, maps, 1);
        if(check) {
            visited = new boolean[maps.length][maps[0].length()];    
            bfs(leberX, leberY, maps, arr[leberX][leberY] + 1);
            if(check2) {
                answer = arr[exitX][exitY];    
            } else{
                answer = -1;
            }
        } else{
            answer = -1;
        }
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        
        
        
        return answer;
    }
    
    public static void bfs(int x, int y, String[] maps, int dis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        int result = dis;
        while(!q.isEmpty()) {    
            for(int i = 0, size = q.size(); i < size; i++) {
                Node node = q.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length() || 
                       maps[nx].charAt(ny) == 'X' || visited[nx][ny]) continue;                    
                    
                    arr[nx][ny] = result;  
                    if(maps[nx].charAt(ny) == 'L') {
                        check = true;
                        return;
                    }
                    if(maps[nx].charAt(ny) == 'E' && check) {
                        check2 = true;
                        return;
                    }
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }    
                
            }
            result++; 
        }        
    }
    
}