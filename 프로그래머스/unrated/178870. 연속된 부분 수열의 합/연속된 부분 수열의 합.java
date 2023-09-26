class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for(int i = 0; i < sequence.length; i++) {
            while(j < sequence.length && sum < k) {
                sum += sequence[j++];
            }
            if(sum == k && j - i < len) {
                start = i;
                end = j - 1;
                len = end - start + 1;
            }
            sum -= sequence[i];
        }
        
        return new int[] {start, end};
    }
}