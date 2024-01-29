class Solution {
    
    // 1부터 number까지 약수의 개수 구하기
    
    public int solution(int number, int limit, int power) {
    
        // init
        int answer = 0;        
        
        // 약수 개수 구하기
        for(int i=1; i<=number; i++) {
            answer += getAttackNum(i, limit, power);
        }
        
        return answer;
    }
    
    public int getAttackNum(int number, int limit, int power) {
        int cnt = 0;
        for(int i=1; i*i<=number; i++) {
            if(i*i == number) cnt++;
            else if(number%i == 0) cnt+=2;
        }
        if(cnt > limit) return power;
        return cnt;
    }
}