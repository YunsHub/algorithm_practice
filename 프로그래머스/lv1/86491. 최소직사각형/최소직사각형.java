class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for(int index = 0; index < sizes.length; index++) {
            width = Math.max(width, Math.max(sizes[index][0], sizes[index][1]));
            height = Math.max(height, Math.min(sizes[index][0], sizes[index][1]));
        }
        int answer = width * height;
        return answer;
    }
}