class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        boolean check = false;
        
        if(A.equals(B)) {
            return answer;
        }
        
        for(int i = 0; i < A.length(); i++) {
            A = A.charAt(A.length() - 1) + A.substring(0, A.length() - 1);
            answer++;
            if(A.equals(B)) {
                check = true;
                break;
            }
        }
        if(!check) {
            answer = -1;
        }
        
        return answer;
    }
}