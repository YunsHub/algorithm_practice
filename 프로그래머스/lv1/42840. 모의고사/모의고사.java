import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] studentA = {1, 2, 3, 4, 5};
        int[] studentB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] studentC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int studentAScore = 0;
        int studentBScore = 0;
        int studentCScore = 0;
        for(int index = 0; index < answers.length; index++) {
            if(answers[index] == studentA[index % 5]) studentAScore++;
            if(answers[index] == studentB[index % 8]) studentBScore++;
            if(answers[index] == studentC[index % 10]) studentCScore++;
        }
        int highScore = Math.max(studentAScore, Math.max(studentBScore, studentCScore));
        int num = 0;
        int idx = 0;
        if(highScore == studentAScore) num++;
        if(highScore == studentBScore) num++;
        if(highScore == studentCScore) num++;
        int[] answer = new int[num];
        if(highScore == studentAScore) answer[idx++] = 1;
        if(highScore == studentBScore) answer[idx++] = 2;
        if(highScore == studentCScore) answer[idx++] = 3;
        
        return answer;
    }
}