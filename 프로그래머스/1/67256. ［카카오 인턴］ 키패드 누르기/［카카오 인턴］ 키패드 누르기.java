import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        // 왼손 : 1 4 7
        // 오른손 : 3 6 9
        // 가운데 : 2 5 8 0
        
        // 2가지 방법 : BFS, 좌표 저장
        
        // 1. 좌표 저장
        ArrayList<int[]> node = new ArrayList<>();
        
        // init
        node.add(new int[] {3, 1});
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                node.add(new int[] {i, j});
            }
        }
        
        int[] leftHand = new int[2];
        int[] rightHand = new int[2];
        leftHand[0] = 3;
        leftHand[1] = 0;
        rightHand[0] = 3;
        rightHand[1] = 2;
        
        
        StringBuilder sb = new StringBuilder();
        for(int number : numbers) {
            
            if(number == 1 || number == 4 || number == 7) {
                sb.append("L");
                leftHand = node.get(number);
            } else if(number == 3 || number == 6 || number == 9) {
                sb.append("R");
                rightHand = node.get(number);
            } else {
                int leftDis = getDistance(leftHand, node.get(number));
                int rightDis = getDistance(rightHand, node.get(number));     
                
                if(leftDis < rightDis) {
                    sb.append("L");
                    leftHand = node.get(number);
                } else if(leftDis > rightDis) {
                    sb.append("R");
                    rightHand = node.get(number);
                } else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        leftHand = node.get(number);
                    } else {
                        sb.append("R");
                        rightHand = node.get(number);
                    }
                }                                                
            }
        }
        
        
        return sb.toString();
    }
    
    public int getDistance(int[] now, int[] next) {
        int dis = (int) Math.abs(now[0] - next[0]) + (int) Math.abs(now[1] - next[1]);        
        return dis;
    }
}