import java.util.*;
import java.time.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Long> termsMap = new HashMap<>();
        for(String term : terms) {
            String[] str = term.split(" ");
            String type = str[0];
            String month = str[1];
            termsMap.put(type, Long.parseLong(month));
        }
        
        String[] todatStr = today.split("\\.");  
        int year = Integer.parseInt(todatStr[0]);
        int month = Integer.parseInt(todatStr[1]);
        int day = Integer.parseInt(todatStr[2]);
        LocalDate now = LocalDate.of(year, month, day);
        
        for(int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            String[] dateStr = str[0].split("\\.");
            String type = str[1];
            long term = termsMap.get(str[1]);
            int y = Integer.parseInt(dateStr[0]);
            int m = Integer.parseInt(dateStr[1]);
            int d = Integer.parseInt(dateStr[2]);
            LocalDate date = LocalDate.of(y, m, d);
            LocalDate local = date.plusMonths(term);
            
            if(!now.isBefore(local)) list.add(i + 1);
        }
        
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }        
        return answer;
    }
}