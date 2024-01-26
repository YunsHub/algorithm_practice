class Solution {
    public int solution(String[][] board, int h, int w) {
        // board[][]:색이 칠해진 보드판, h:x좌표, w:y좌표
        // board[h][w] 좌표에서 4방향 탐색으로
        // 같은 색이 있으면 answer++;
        
        // init
        int answer = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        String color = board[h][w];
        
        // cal
        for(int dir=0; dir<4; dir++) {
            int nx = h + dx[dir];
            int ny = w + dy[dir];
            if(isRange(nx, ny, board.length) && color.equals(board[nx][ny])) answer++;
        }
        
        return answer;
    }
    
    public boolean isRange(int x, int y, int len) {
        return x>=0 && y>=0 && x<len && y<len;
    }
}