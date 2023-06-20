import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] alphabet = new int[27];
        for(int i = 0; i < survey.length; i++) {
            if(choices[i] == 4) continue;
            else if(choices[i] < 4) {
                char c = survey[i].charAt(0);
                alphabet[c - 64] += (4 - choices[i]);
            } else {
                char c = survey[i].charAt(1);
                alphabet[c - 64] += (choices[i] % 4);
            }
        }
        if(alphabet['R' - 64] < alphabet['T' - 64]) {
            answer += "T";
        } else {
            answer += "R";
        }
        if(alphabet['C' - 64] < alphabet['F' - 64]) {
            answer += "F";
        } else {
            answer += "C";
        }
        if(alphabet['J' - 64] < alphabet['M' - 64]) {
            answer += "M";
        } else {
            answer += "J";
        }
        if(alphabet['A' - 64] < alphabet['N' - 64]) {
            answer += "N";
        } else {
            answer += "A";
        }
        
        
        return answer;
    }
}