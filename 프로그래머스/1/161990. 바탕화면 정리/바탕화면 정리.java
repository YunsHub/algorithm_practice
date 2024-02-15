class Solution {
    public int[] solution(String[] wallpaper) {
        int sx = 50, sy = 50, ex = 0, ey = 0;
        int width = wallpaper.length;
        int height = wallpaper[0].length();
        
        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    sx = Math.min(sx, i);
                    sy = Math.min(sy, j);
                    ex = Math.max(ex, i);
                    ey = Math.max(ey, j);
                }
            }
        }
        
        int[] answer = new int[] {sx, sy, ex+1, ey+1};
        return answer;
    }
}