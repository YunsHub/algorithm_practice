class Solution {
    boolean[] prime;
    int answer = 0;
    public int solution(int[] nums) {
        int max = 3_001;        
        prime = new boolean[max];
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i < max; i++) {
            if(prime[i]) continue;
            
            for(int j = i*i; j < max; j+=i) {
                prime[j] = true;
            }
        }
        
        
        boolean[] visited = new boolean[nums.length];
        comb(0, 0, nums, visited, 0);
        return answer;
    }    
    
    public void comb(int idx, int cnt, int[] nums, boolean[] visited, int sum) {
        if(cnt == 3) {
            if(!prime[sum]) answer++;
            return;
        }
        
        for(int i = idx; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1, cnt+1, nums, visited, sum + nums[i]);
                visited[i] = false;
            }
        }
    }
}