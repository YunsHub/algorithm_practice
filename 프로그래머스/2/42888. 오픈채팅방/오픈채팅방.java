import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for(String info : record) {
            StringTokenizer st = new StringTokenizer(info);
            String state = st.nextToken();
            if(!state.equals("Change")) cnt++;
            if(state.equals("Leave")) continue;
            
            String id = st.nextToken();
            String nickname = st.nextToken();
            idMap.put(id, nickname);
        }
        
        String[] answer = new String[cnt];
        int answerIdx = 0;
        for(String info : record) {
            StringTokenizer st = new StringTokenizer(info);
            String state = st.nextToken();
            if(state.equals("Enter")) {
                String id = idMap.get(st.nextToken());
                answer[answerIdx++] = id + "님이 들어왔습니다.";
            } else if(state.equals("Leave")) {
                String id = idMap.get(st.nextToken());
                answer[answerIdx++] = id + "님이 나갔습니다.";
            }
        }
        
        // idMap.forEach((key, value) -> {
        //     System.out.println(key + " " + value);
        // });
        
        
        return answer;
    }
}