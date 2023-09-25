class Solution {
    public int solution(String[] board) {
        // 게임이 성공적        
        // 가로 세로 대각선 빙고 (XO 중 하나만)
        // 게임이 끝날 땐 O는 항상 X보다 1많아야 함
//         O의 개수-X의 개수=0 or 1
// O가 이겼다면 O의 개수는 X보다 한 개 많음.
// X가 이겼다면 O의 개수와 X의 개수는 같음.
// O와 X는 동시에 이길 수 없음.
        int oCnt = 0;
        int xCnt = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'O') oCnt++;
                else if(board[i].charAt(j) == 'X') xCnt++;
            }
        }
        if(oCnt != xCnt + 1 && oCnt != xCnt) return 0;
        if(bingo(board, 'O') && bingo(board, 'X')) return 0;
        if(oCnt != xCnt && bingo(board, 'X')) return 0;
        if(oCnt != xCnt + 1 && bingo(board, 'O')) return 0;
        
        return 1;
    }
    public boolean bingo(String[] board, char word) {        
        for(int i = 0; i < 3; i++) {
            if((board[i].charAt(0) == word && board[i].charAt(1) == word && board[i].charAt(2) == word)
              || (board[0].charAt(i) == word && board[1].charAt(i) == word && board[2].charAt(i) == word)) {
                return true;                      
            }
        }
        if((board[0].charAt(0) == word && board[1].charAt(1) == word && board[2].charAt(2) == word) 
           || (board[0].charAt(2) == word && board[1].charAt(1) == word && board[2].charAt(0) == word)) {
            return true;
        }
        return false;
    }
}