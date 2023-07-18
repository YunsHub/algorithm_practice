import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> members = new HashMap<>();
        String answer = "";
        for(int Index = 0; Index < participant.length; Index++) {
            members.put(participant[Index], members.getOrDefault(participant[Index], 0) + 1);
        }    
        for(int Index = 0; Index < completion.length; Index++) {
            members.put(completion[Index], members.get(completion[Index]) - 1);
        }
        for(String name : members.keySet()) {
            if(members.get(name) != 0) {
                answer = name;        
                break;
            }
        }
        
        return answer;
    }
}