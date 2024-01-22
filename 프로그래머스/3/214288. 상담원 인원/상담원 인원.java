import java.util.*;

class Solution {
    
    // 각 유형별로 최소 1명씩은 멘토가 있으므로
    // 유형별로 1명일 경우 기다리는 시간을 계산한다.
    // 1명을 추가했을 때 기다리는 시간이 가장 많이 줄어드는
    // 유형에 1명을 추가하는 작업을 n명까지 반복한다.
    // 기다리는 시간의 총합을 출력한다.
    
    public int solution(int k, int n, int[][] reqs) {
        // k:유형의 수, n:멘토의 수
        // init
        List<int[]>[] reqListArr = new ArrayList[k+1];
        int[] mentorNumberArr = new int[k+1];
        int[] waitingTimeArr = new int[k+1];
        
        for(int i=1; i<=k; i++) {
            reqListArr[i] = new ArrayList<>();
            mentorNumberArr[i]++;
        }
        
        // List에 유형별로 시간 저장
        for(int[] req : reqs) {
            reqListArr[req[2]].add(new int[] {req[0], req[1]});
        }
        
        // 유형별로 1명일 때 waitingTime 저장
        for(int i=1; i<=k; i++) {
            waitingTimeArr[i] = getWaitingTime(reqListArr[i], mentorNumberArr[i]);
        }
        //System.out.println(Arrays.toString(waitingTimeArr));
        
        // cal
        for(int i=k; i<n; i++) {
            int maxTime = 0;
            int maxIndex = 0;
            
            // 기다리는 시간 차이가 가장 큰 maxTime, maxIndex 구하기
            for(int j=1; j<=k; j++) {
                int waitingTime = getWaitingTime(reqListArr[j], mentorNumberArr[j] + 1);
                if(maxTime < waitingTimeArr[j] - waitingTime) {
                    maxTime = waitingTimeArr[j] - waitingTime;
                    maxIndex = j;
                }
            }
            
            // max값에 의해 인원 수와 기다리는 시간 저장
            waitingTimeArr[maxIndex] -= maxTime;
            mentorNumberArr[maxIndex]++;
        }
        
        int answer = 0;
        for(int time : waitingTimeArr) {
            answer += time;
        }
    
        return answer;        
    }    
    
    // 인원 수에 맞춘 기다리는 시간 계산
    public int getWaitingTime(List<int[]> reqList, int peopleNumber) {
        // 끝나는 시간 우선순위 큐
        PriorityQueue<Integer> timeQueue = new PriorityQueue<>();        
        int waitingTime = 0;
        
        for(int[] req : reqList) {
            if(timeQueue.size() >= peopleNumber) {
                int time = timeQueue.poll();
                if(req[0] < time) {
                    waitingTime += (time - req[0]);
                    timeQueue.add(time + req[1]);
                    continue;
                } 
            }
            timeQueue.add(req[0] + req[1]);
        }
        
        return waitingTime;
    }
}