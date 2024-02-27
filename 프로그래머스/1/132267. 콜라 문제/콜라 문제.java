class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;                
        int mod = 0;
        
        while(true) {
            answer += (n / a) * b;
            mod = (n % a);
            n = (n / a) * b;
            if(n == 0) break;
            n += mod;
        }
        
        return answer;
    }
}