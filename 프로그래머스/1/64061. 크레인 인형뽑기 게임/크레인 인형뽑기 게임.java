class Solution {
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0, n = board.length, now = 0;
        int[] height = new int[n];
        int[] arr = new int[moves.length+1];
        
        init(n, board, height, arr);
        
        //simulation
        for(int m : moves){
            m--;
            
            //인형이 없다면
            if(height[m] >= n) continue;
            
            //인형이 있다면
            int next = board[height[m]][m];
            height[m]++;
            
            if(arr[now] != next){
                arr[++now] = next;
            }
            else{
                now--;
                answer++;
            }
        }
        
        return answer*2;
    }
    
    public void init(int n, int[][] board, int[] height, int[] arr){
        arr[0] = -1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n ;j++){
                if(board[j][i] > 0){
                    height[i] = j;
                    break;
                }
            }
        }
        
    }
}