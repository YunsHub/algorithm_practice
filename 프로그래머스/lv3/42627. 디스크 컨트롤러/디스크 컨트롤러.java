import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        // jobs 요청 시간 오름차순 (하드 디스크에 넣을 배열)
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // pq 작업 시간 오름차순 (하드 디스크)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int time = jobs[0][0];
        int sum = 0;
        int cnt = 0;
        int index = 0;
        while(cnt < jobs.length) {
            
            while(index < jobs.length && jobs[index][0] <= time) {
                pq.add(jobs[index++]);
            }
            
            if(!pq.isEmpty()) {
                int[] now = pq.poll();                
                sum += now[1] + time - now[0];    
                time += now[1];
                cnt++;
            } else {
                time = jobs[index][0];
            }
        }
        return sum / jobs.length;
    }
}