import java.util.*;
import java.text.*;

class Solution {
    public class Plan{
        String name;
        int playTime;
        
        public Plan(String name, int playTime) {
            this.name = name;
            this.playTime = playTime;
        }
    }
    
    public String[] solution(String[][] plans) throws Exception {
        int answerIdx = 0;
        int len = plans.length;
        String[] answer = new String[len];
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stack<Plan> s = new Stack<>();
        
        Arrays.sort(plans, (o1, o2) -> {
            return o1[1].compareTo(o2[1]);
        });
        System.out.println(Arrays.deepToString(plans));
        
        for(int i = 0; i < len-1; i++) {
            int playTime = Integer.parseInt(plans[i][2]);
            
            Date d1  = dateFormat.parse(plans[i][1]);
            Date d2  = dateFormat.parse(plans[i+1][1]);
            
            long timeMil1 = d1.getTime();
            long timeMil2 = d2.getTime();
            long diff = timeMil2 - timeMil1;
            
            long diffTime = diff / (1000*60);
            
            if(diffTime >= playTime) {
                answer[answerIdx++] = plans[i][0];
                int endTime = (int) diffTime - playTime;
                while(!s.isEmpty() && endTime > 0) {
                    Plan plan = s.pop();
                    int time = plan.playTime;
                    if(plan.playTime <= endTime) {                        
                        answer[answerIdx++] = plan.name;
                        endTime -= time;
                    } else {                        
                        s.push(new Plan(plan.name, plan.playTime - endTime));
                        endTime = 0;
                    }
                }
            } else {
                int endTime = playTime - (int) diffTime;
                s.push(new Plan(plans[i][0], endTime));
            }
        }
        
        answer[answerIdx++] = plans[len-1][0];                
        while(!s.isEmpty()) answer[answerIdx++] = s.pop().name;            
        
        
        
        
        return answer;
    }
}