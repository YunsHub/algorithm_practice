import java.util.*;
class Solution {
    public ArrayList<int[]> node;
    public String solution(int[] numbers, String hand) {
        // 왼손 : 1 4 7
        // 오른손 : 3 6 9
        // 가운데 : 2 5 8 0
        
        // 2가지 방법 : 좌표 저장
        
        // 1. 좌표 저장
        node = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // init
        hand = hand.equals("left") ? "L" : "R";
        int[] leftHand = {3, 0};
        int[] rightHand = {3, 2};
        
        node.add(new int[] {3, 1});
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                node.add(new int[] {i, j});
            }
        }
        
        for(int number : numbers) {            
            String nowHand = getHand(hand, number, leftHand, rightHand);
            sb.append(nowHand);
            
            if(nowHand.equals("L")) leftHand = node.get(number);
            else rightHand = node.get(number);
        }        
        
        return sb.toString();
    }
    
    public String getHand(String handed, int number, int[] leftHand, int[] rightHand) {
        if(number == 1 || number == 4 || number == 7) {
            return "L";
        } else if(number == 3 || number == 6 || number == 9) {
            return "R";  
        } 
        
        int leftDis = getDistance(leftHand, node.get(number));
        int rightDis = getDistance(rightHand, node.get(number));     

        if(leftDis < rightDis) {
            return "L";
        } else if(leftDis > rightDis) {
            return "R";
        }             
        
        return handed;
    }
    
    public int getDistance(int[] now, int[] next) {
        int dis = (int) Math.abs(now[0] - next[0]) + (int) Math.abs(now[1] - next[1]);        
        return dis;
    }
}