import java.util.*;
class Solution {
    // 점수 | 보너스 | 옵션
    // 점수 : 0~10
    // 보너스 : S D T
    // 옵션 : * # Empty
    // 출력 : 3번의 기회에서 얻은 점수 합계
    
    int DART_NUM = 3;
    public int solution(String dartResult) {
        char[] dart = dartResult.toCharArray();
        int[] num = new int[DART_NUM];
        
        for(int i=0, idx=0; i<DART_NUM; i++) {
            num[i] = dart[idx++] - '0';
            if(dart[idx] - '0' == 0) {
                num[i] = 10;
                idx++;
            }
            
            char bonus = dart[idx++];
            if(bonus == 'D') {
                num[i] = (int) Math.pow(num[i], 2);
            } else if(bonus == 'T') {
                num[i] = (int) Math.pow(num[i], 3);
            }
                
            if(idx >= dart.length) break;
            char ops = dart[idx];
            if(ops == '*') {
                idx++;
                num[i] *= 2;
                if(i != 0) num[i-1] *= 2;
            } else if(ops == '#') {
                idx++;
                num[i] *= (-1);
            }
        }
        
        
        int answer = 0;
        for(int n : num) {
            answer += n;
        }
        
        return answer;
    }
}