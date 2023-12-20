class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;        
        int time = 1;
        int cnt = 0;
        int idx = 0;        
        int length = attacks.length;
        
        while(idx < length) {
            if(time == attacks[idx][0]) {
                answer -= attacks[idx][1];
                idx++;
                cnt = 0;
            } else if(answer + bandage[1] <= health) {
                answer += bandage[1];
                cnt++;
                if(cnt == bandage[0]) {
                    cnt = 0;
                    if(answer + bandage[2] <= health) answer += bandage[2];                    
                }                 
            } else answer = health;                        
            
            if(answer <= 0) return -1;                    
            time++;
        }
                
        return answer;
    }
}