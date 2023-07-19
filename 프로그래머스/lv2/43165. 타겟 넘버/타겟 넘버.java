class Solution {
    public static int result;
    public int solution(int[] numbers, int target) {
        recur(numbers, 0, 0, target);
        int answer = result;
        return answer;
    }
    public void recur(int[] numbers, int index, int sum, int target) {
        if(index == numbers.length) {        
            if(sum == target) {
                result++;
            }
            return;
        }
        recur(numbers, index + 1, sum + numbers[index], target);
        recur(numbers, index + 1, sum - numbers[index], target);
    }
}