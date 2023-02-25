class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int sum = 1000;
        // 3 0
        while(true) {
            int result = 0;
            for(int i = 0; i < num; i++) {
                result += sum - i;    
            }
            if(result == total) {
                for(int i = 0; i < num; i++) {
                    answer[i] = sum - num + i + 1;        
                }
                break;    
            } else{
                sum--;
            }
        }
        
        return answer;
    }
}