import java.util.*;
class Solution {
    
    public int[] sales = {10, 20, 30, 40};
    public int[] sale;
    public int subscribeEmotion = 0;
    public int totalPrice = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int len = emoticons.length;
        sale = new int[len];
        permutation(0, 0, len, users, emoticons);

        
        int[] answer = {subscribeEmotion, totalPrice};
        return answer;
    }
    
    public void permutation(
        int idx, int cnt, int len, int[][] users, int[] emoticons
    ) {
        if(cnt == len) {
            // System.out.println(Arrays.toString(sale));
            saleEvent(users, emoticons);
            return;
        }
        for(int i = 0; i < 4; i++) {
            sale[cnt] = sales[i];
            permutation(i + 1, cnt + 1, len, users, emoticons);
        }
    }
    
    public void saleEvent(int[][] users, int[] emoticons) {
        int subscribe = 0;
        int total = 0;
        
        for(int[] user : users) {
            int price = 0;
            for(int i = 0; i < emoticons.length; i++) {
                if(sale[i] < user[0]) continue;
                price += ((emoticons[i] * (100 - sale[i])) / 100);
            }

            if(price >= user[1]) subscribe++;
            else total += price;
        }
        
        if(subscribe >= subscribeEmotion) {
            if(subscribe == subscribeEmotion) 
                totalPrice = Math.max(totalPrice, total);
            else totalPrice = total;    
            
            subscribeEmotion = subscribe;
            
        }
        
    }
}