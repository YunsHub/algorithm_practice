class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long num = Long.parseLong(p);
        for(int i = 0; i <= t.length() - p.length(); i++) {
            String str = t.substring(i, i + p.length());
            if(Long.parseLong(str) <= num) answer++;
        }
        
        return answer;
    }
}