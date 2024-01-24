import java.util.*;

class Solution {
    
    int[] answer = new int[4];
    int MAX = 0;
    
    public int[] solution(int[][] edges) {
        // 무관한 정점을 생성한 edges에서
        // 무관한 정점과 도넛, 막대, 8자 모양 그래프의 개수를 구하기.
        
        // 무관한 정점 찾기 : 다른 정점에서 오는 간선이 없는 정점
        // 도넛 그래프 : 
        
        // init                
        MAX = edges.length+1;
        List<Integer>[] inList = new ArrayList[MAX+1];
        List<Integer>[] outList = new ArrayList[MAX+1];
        
        
        for(int i=1; i<=MAX; i++) {
            inList[i] = new ArrayList<>();
            outList[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            inList[edge[1]].add(edge[0]);
            outList[edge[0]].add(edge[1]);
        }
        
        findNode(inList, outList);
        
        for(int node : outList[answer[0]]) {
            countGraph(node, outList);
        }
        
        return answer;
    }

    public void countGraph(int node, List<Integer>[] outList) {
        boolean[] visited = new boolean[MAX+1];
        
        while(!visited[node]) {
            visited[node] = true;
            
            // 8자 그래프
            if(outList[node].size() == 0) {
                answer[2]++;
                return;
            } else if(outList[node].size() == 2) {
                answer[3]++;
                return;
            }            
            node = outList[node].get(0);
        }
        
        answer[1]++;
    }
    
    public void findNode(List<Integer>[] inList, List<Integer>[] outList) {        
        for(int i=1; i<inList.length; i++) {
            if(inList[i].size() == 0) {
                if(outList[i].size() > 1) {
                    answer[0] = i;
                    return;    
                }                
                answer[0] = i;
            }
        }
    }
}