import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < elements.length; i++) {
            sum = 0;
            for(int j = i; j < i + elements.length; j++) {
                sum += elements[j % elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}