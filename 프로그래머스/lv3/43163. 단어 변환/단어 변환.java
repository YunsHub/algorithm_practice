class Solution {
    public int answer = 0;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(0, begin, target, words, visited);
        return answer;
    }
    
    public void dfs(
        int depth, String begin, String target, String[] words, boolean[] visited
    ) {
        if(begin.equals(target)) {
            System.out.println(depth);
            answer = depth;
            return;
        }
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            int len = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) len++;
            }
            if(len == begin.length() - 1) {
                visited[i] = true;
                dfs(depth + 1, words[i], target, words, visited);
                visited[i] = false;
            }
        }
    }
}