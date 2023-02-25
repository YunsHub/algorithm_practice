class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
//         int num1 = common[1] - common[0];
//         int num2 = common[2] - common[1];
//         int num3 = common[1] / common[0];
        
        if(common[2] - common[1] == common[1] - common[0]) {
            answer = common[common.length - 1] + common[1] - common[0];
        } else{
            answer = common[common.length - 1] * (common[1] / common[0]);
        }
        // if (common[2] - common[1] == common[1] - common[0]){
        //   answer = common[common.length - 1] + (common[1] - common[0]);
        // } else {
        //   answer = common[common.length - 1] * (common[1] / common[0]);
        // }
        return answer;
    }
}