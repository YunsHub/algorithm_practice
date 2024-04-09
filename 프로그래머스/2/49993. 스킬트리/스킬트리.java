import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees) {
            boolean[] visited = new boolean[26];
            Arrays.fill(visited, true);
            for(int i=1; i<skill.length(); i++) {
                visited[skill.charAt(i)-'A'] = false;
            }
            int index = 0;
            
            char[] skillNum = skill_tree.toCharArray();
            boolean check = true;
            
            for(char sk : skillNum) {
                if(visited[sk-'A']) {
                    if(index < skill.length()-1 && skill.charAt(index) == sk) {
                        index++;
                        visited[skill.charAt(index) - 'A'] = true;
                    }
                } else {
                    check = false;
                    break;
                }
            }
            
            if(check) answer++;
        }
        
        
        return answer;
    }
}