import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        
        for(int i = 0; i < book_time.length; i++) {
            StringTokenizer st1 = new StringTokenizer(book_time[i][0], ":");
            time[i][0] = Integer.parseInt(st1.nextToken()) * 60 + Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(book_time[i][1], ":");
            time[i][1] = Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());         
        }
        
        Arrays.sort(time, (o1, o2) -> o1[0] - o2[0]);
        
        for(int i = 0; i < time.length; i++) {
            if(!pq.isEmpty() && pq.peek() <= time[i][0]) {
                pq.poll();
            } else {
                answer++;                
            }
            pq.add(time[i][1] + 10);
        }
        //System.out.println(Arrays.deepToString(time));
        
        return answer;
    }
}