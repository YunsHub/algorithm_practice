class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for(int index = 0; index < sizes.length; index++) {
            if(sizes[index][0] > sizes[index][1]) {
                width = Integer.max(width, sizes[index][0]);
                height = Integer.max(height, sizes[index][1]);
            } else {
                height = Integer.max(height, sizes[index][0]);
                width = Integer.max(width, sizes[index][1]);                
            }
        }
        int answer = width * height;
        return answer;
    }
}