import java.util.*;
class Solution {
    Map<String, Integer> map;
    int max;
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        
        for(int c : course) {
            map = new TreeMap<>();
            max = 2;
            for(int i=0; i<orders.length; i++) {                
                boolean[] visited = new boolean[orders[i].length()];
                char[] order = orders[i].toCharArray();
                Arrays.sort(order);
                permutation("", order, 0, 0, c, visited);
            }    
            
            map.forEach((key,value) -> {
                if(value == max) {
                    answerList.add(key);
                }
            });
            
        }
        
        
        String[] answer = new String[answerList.size()];
        int answerIdx = 0;
        Collections.sort(answerList);
        for(String str : answerList) {
            answer[answerIdx++] = str; 
        }
        
        
        return answer;
    }
    
    public void permutation(String target, char[] order, int idx, int cnt, int course, boolean[] visited) {
        if(cnt == course) {
            // System.out.println(target);
            map.put(target, map.getOrDefault(target, 0) + 1);
            max = Math.max(max, map.get(target));
            return;
        }
        
        for(int i=idx; i<order.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(target + order[i], order, i+1, cnt+1, course, visited);
                visited[i] = false;
            }
        }
        
    }
}