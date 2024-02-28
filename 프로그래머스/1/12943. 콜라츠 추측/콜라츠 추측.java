class Solution {
    public int solution(int num) {
        int answer = 0;
        
        while(true) {
            if(num==1 || answer==500) break;
            
            if(num%2==0) num/=2;
            else if(num%2==1) num = (num*3)+1;
            answer++;
        }
        
        return answer == 500 ? -1 : answer;
    }
}