import java.util.*;
class Solution {
    
    class Fail {
        int stage;
        double failPercentage;
        
        public Fail(int stage, double failPercentage) {
            this.stage = stage;
            this.failPercentage = failPercentage;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageCnt = new int[N+1];
        
        for(int stage : stages) {
            stageCnt[stage-1]++;
        }
        
        int total = stages.length;
        Fail[] failArr = new Fail[N];
        
        for(int i=0; i<N; i++) {
            double per = 0;
            if(total!=0) per = ((double) stageCnt[i] * 100.0 / (double) total);
            failArr[i] = new Fail(i+1, per);
            total -= stageCnt[i];
        }
        
        Arrays.sort(failArr, (o1, o2) -> {
            if(o2.failPercentage == o1.failPercentage) {
                return o1.stage - o2.stage;
            }
            return Double.compare(o2.failPercentage,o1.failPercentage);
        });
        
        
        for(int i=0; i<N; i++) {
            answer[i] = failArr[i].stage;
            // System.out.println(failArr[i].failPercentage);
        }
        
        return answer;
    }
}