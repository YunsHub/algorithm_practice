class Solution {    
    public int solution(int number, int limit, int power) {

        // init
        int answer = 0;        
        int[] attack = new int[number+1];
        
        // 1부터 number까지 배수 저장
        for(int i=1; i<=number; i++) {
            for(int j=1; j<=number/i; j++) {
                attack[i*j]++;
            }
        }
        
        for(int i=1; i<=number; i++) {
            if(attack[i] > limit) answer += power;
            else answer += attack[i];
        }

        return answer;
    }
}