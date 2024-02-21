class Solution {
    public int solution(String s) {
        int sLen = s.length();
        
        if(sLen == 1) return 1;
        
        int len = sLen / 2;
        int answer = Integer.MAX_VALUE;
        
        while(len != 0) {
            int nowLen = 0;
            int cnt = 1;
            String temp = "";
            int digit = 0;
            
            for(int i = 0; i < sLen; i+=len) {
                if(i+len <= sLen) {
                    String divStr = s.substring(i, i+len);
                    if(temp.equals(divStr)) {
                        cnt++;
                        if(digit != Integer.toString(cnt).length()) {
                            digit++;
                            nowLen++;                        
                        }
                    } else {
                        temp = divStr;
                        nowLen += len;
                        cnt = 1;
                        digit = 0;
                    }
                } else {
                    nowLen += s.length()-i;
                }
            }
            
            answer = Math.min(answer, nowLen);
            len--;
        }
         
        return answer;
    }
}