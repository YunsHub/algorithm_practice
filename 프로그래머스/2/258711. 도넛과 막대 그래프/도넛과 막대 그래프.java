import java.util.*;

class Solution {

    int[] answer = new int[4];
    int MAX = 0;

    public int[] solution(int[][] edges) {
        // 무관한 정점을 생성한 edges에서
        // 무관한 정점과 도넛, 막대, 8자 모양 그래프의 개수를 구하기.

        // 무관한 정점 찾기
        // 정점에 들어오는 간선 == 0 && 나가는 간선 > 1을 충족해야 함
        // 예시 1번의 4번 정점과 같이 들어오는 간선은 없지만 
        // 나가는 간선이 1개인 것은 막대 그래프일 수도 있기 때문
        
        // 그래프 개수 세기
        // 무관한 정점에 다 이어져 있기 때문에
        // out[무관한 정점]을 기준으로 돌면서
        // 도넛, 막대, 8자 모양 그래프 개수를 세어준다.
    
        // init       
        MAX = edges.length + 2;
        int[] inArr = new int[MAX];
        int[] outArr = new int[MAX];
        
        for(int[] edge : edges) {
            inArr[edge[1]]++;
            outArr[edge[0]]++;
        }
        
        // 무관한 정점 찾기
        answer[0] = findNode(inArr, outArr);
        
        // 그래프 모양 개수 구하기
        countGraph(inArr, outArr);
        
        answer[1] = outArr[answer[0]] - answer[2] - answer[3];
        return answer;
    }
    
    public int findNode(int[] inArr, int[] outArr) {        
        int node = 0;
        
        for(int i=1; i<MAX; i++) {
            if(inArr[i] == 0) {
                if(outArr[i] > 1) return i;
                node = i;
            } 
        }
        return node;
    }

    public void countGraph(int[] inArr, int[] outArr) {
        for(int i=1; i<MAX; i++) {
            if(i == answer[0]) continue;
            
            if(outArr[i] > 1) answer[3]++;
            else if(inArr[i] > 0 && outArr[i] == 0) answer[2]++;
        }
    }

    
}
