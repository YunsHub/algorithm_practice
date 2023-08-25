import java.util.*;
class Solution {
    public static class Finds{
        int location;
        int priorities;
        public Finds(int location, int priorities) {
            this.location = location;
            this.priorities = priorities;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Finds> q = new LinkedList<>();
        for(int index = 0; index < priorities.length; index++) {
            q.add(new Finds(index, priorities[index]));
        }
        

        while(!q.isEmpty()){        
            Finds findNum = q.poll();
            boolean check = false;
            for(int size = 0; size < q.size(); size++) {
                Finds findCompare = q.poll();
                if(findCompare.priorities > findNum.priorities) check = true;
                q.add(findCompare);
            }            
            if(check) q.add(findNum);
            else {                
                if(findNum.location == location) return answer;
                answer++;
            }
        }
        return answer;
    }
}