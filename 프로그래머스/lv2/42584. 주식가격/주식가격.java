import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
         for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        // for(int index = 0; index <prices.length; index++) {
        //     for(int num = index + 1; num <prices.length; num++) {
        //         if(prices[index] > prices[num]) break;
        //         answer[index]++;                
        //     }
        // } 
        
        
        return answer;
    }
}