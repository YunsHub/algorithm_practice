import java.util.*;
import java.text.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        ArrayList<Integer> result = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date todayDate = format.parse(today);    
        for(int i = 0; i < privacies.length; i++) {
            StringTokenizer st1 = new StringTokenizer(privacies[i]);
            String date = st1.nextToken();
            String type = st1.nextToken();
            int destroyDay = 0;
            for(int j = 0; j < terms.length; j++) {
                StringTokenizer st2 = new StringTokenizer(terms[j]);                
                if(type.equals(st2.nextToken())) {
                    destroyDay = Integer.parseInt(st2.nextToken());
                    break;
                }
            }
            Date calDate = format.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(calDate);
            cal.add(Calendar.MONTH, destroyDay);
            if(todayDate.after(format.parse(format.format(cal.getTime())))
              || todayDate.equals(format.parse(format.format(cal.getTime())))) {
                result.add(i + 1);
            }
            
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0 ; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
    
        
        return answer;
    }
}