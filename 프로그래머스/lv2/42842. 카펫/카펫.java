class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;    
        for(int x = 1; x * x <= sum; x++) {
            if(sum % x == 0) {
                int height = x;
                int width = sum / x;
                if((width * 2) + (height * 2) - 4 == brown) {
                    answer[0] = width;
                    answer[1] = height;
                }
            } 
        }
        
        return answer;
    }
}