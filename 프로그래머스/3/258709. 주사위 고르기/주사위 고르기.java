import java.util.*;

class Solution {
    
    int[] answer;
    int DICE_DIR = 6;
    int diceNum = 0;
    int maxWin = 0;
    
    public int[] solution(int[][] dice) {
        
        // init
        diceNum = dice.length;
        boolean[] visited = new boolean[diceNum];
        visited[0] = true;
        answer = new int[diceNum / 2];
        
        // 주사위를 나눠가지는 경우의 수
        combination(1, 0, visited, dice);
        
        
        return answer;
    }
    
    public void combination(int idx, int cnt, boolean[] visited, int[][] dice) {
        if(cnt == diceNum / 2 - 1) {
            // 각 주사위의 합
            int[] AScore = getSumDiceScore(true, visited, dice);
            int[] BScore = getSumDiceScore(false, visited, dice);
            
            // 정렬
            Arrays.sort(AScore);
            Arrays.sort(BScore);
            
            // 이긴 횟수 count
            int AwinCount = getWinCount(AScore, BScore);
            int BwinCount = getWinCount(BScore, AScore);
            
            // A가 이겼을 경우
            int answerIdx = 0;
            if(maxWin < AwinCount) {
                maxWin = AwinCount;
                for(int i=0; i<visited.length; i++) {
                    if(visited[i]) answer[answerIdx++] = i + 1;
                }
            }
            
            // B가 이겼을 경우
            answerIdx = 0;
            if(maxWin < BwinCount) {
                maxWin = BwinCount;
                for(int i=0; i<visited.length; i++) {
                    if(!visited[i]) answer[answerIdx++] = i + 1;
                }
            }
            
            return;
        }
        
        for(int i=idx; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(i+1, cnt+1, visited, dice);
                visited[i] = false;
            }
        }
    }
    
    public int getWinCount(int[] score1, int[] score2) {
        int winCount = 0;
        
        for(int i=0; i<score1.length; i++) {
            for(int j=0; j<score2.length; j++) {
                if(score1[i] > score2[j]) {
                    winCount++;
                } else break;
            }
        }
        
        return winCount;
    }
    
    public int[] getSumDiceScore(boolean team, boolean[] visited, int[][] dice) {
        int[] arr = new int[(int) Math.pow(DICE_DIR, diceNum/2)];
        int[] select = new int[diceNum / 2];
        int index = 0;
        idx = 0;
        
        for(int i=0; i<diceNum; i++) {
            if(visited[i] == team) {
                select[index++] = i;
            }
        }
        
        // 나눠가진 주사위의 합
        permutation(0, arr, select, 0, dice);
        
        return arr;
    }
    
    int idx;
    public void permutation(int cnt, int[] arr, int[] select, int sum, int[][] dice) {
        if(cnt == diceNum/2) {
            arr[idx++] = sum;
            return;
        }
        
        for(int i=0; i<DICE_DIR; i++) {
            permutation(cnt+1, arr, select, sum + dice[select[cnt]][i], dice);
        }
    }
    
    
}