import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int answer = 0;
        for(int num : nums) {
            numSet.add(num);
        }
        if(numSet.size() > nums.length / 2) {
            answer = nums.length / 2;
        } else {
            answer = numSet.size();
        }
        
        return answer;
    }
}