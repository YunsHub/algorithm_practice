class Solution {
    public int solution(int[] numbers, int target) {        
        int answer = recur(numbers, 0, 0, target);
        return answer;
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