import java.util.*;

class Solution {
    
    int LOTTO_NUM = 6;
    
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int lottoIdx=0, winIdx=0;
        int lottoCnt=0, zeroCnt=0;
        
        while(lottoIdx < LOTTO_NUM && winIdx < LOTTO_NUM) {
            if(lottos[lottoIdx] == 0) {
                zeroCnt++;
                lottoIdx++;
            } else if(lottos[lottoIdx] > win_nums[winIdx]) {
                winIdx++;
            } else if(lottos[lottoIdx] < win_nums[winIdx]) {
                lottoIdx++;
            } else {
                lottoCnt++;
                lottoIdx++;
            }
        }
        
        int[] order = {6, 6, 5, 4, 3, 2, 1, 1, 1};
        int max = order[lottoCnt + zeroCnt];
        int min = order[lottoCnt];
        
        int[] answer = {max, min};
        return answer;
    }
}