class Solution {
    int answer = 0;
    public void cal(int cnt, int[] numbers, int target, int sum) {
        if(cnt == numbers.length) {
            if(target == sum) answer++;
            return;
        }
        cal(cnt+1, numbers, target, sum + numbers[cnt]);
        cal(cnt+1, numbers, target, sum -numbers[cnt]);        
    }
    public int solution(int[] numbers, int target) {  
        cal(0, numbers, target, 0);
        return answer;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // int answer = recur(numbers, 0, 0, target);
        // return answer;
    }
    public int recur(int[] numbers, int index, int sum, int target) {
        if(index == numbers.length) {        
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return recur(numbers, index + 1, sum + numbers[index], target)
            + recur(numbers, index + 1, sum - numbers[index], target);
    }
}