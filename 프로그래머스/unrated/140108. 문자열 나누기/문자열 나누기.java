class Solution {
    public int solution(String s) {
        int answer = 0;        
        int index = 0;
        while(index < s.length()) {        
            char word = s.charAt(index++);
            int Xcnt = 1;
            int Ycnt = 0;
            while(Xcnt != Ycnt && index < s.length()) {                
                if(word == s.charAt(index)) Xcnt++;
                else Ycnt++;
                index++;
            }
            answer++;
        }
        
        
        return answer;
    }
}