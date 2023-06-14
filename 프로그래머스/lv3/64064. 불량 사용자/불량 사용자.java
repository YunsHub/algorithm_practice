import java.util.*;
class Solution {
    public static int result;
    public static TreeSet<String> set = new TreeSet<>();
    public static Set<String> checkSet = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {      
        result = 0;
        ArrayList<String>[] id = new ArrayList[banned_id.length];    
        for(int i = 0; i < banned_id.length; i++) {
            id[i] = new ArrayList();
        }
        
        for(int i = 0; i < banned_id.length; i++) {
            for(int j = 0; j < user_id.length; j++) {
                boolean flag = true;
                if(banned_id[i].length() != user_id[j].length()) continue;
                for(int k = 0; k < banned_id[i].length(); k++) {
                    if(banned_id[i].charAt(k) == '*' || banned_id[i].charAt(k) == user_id[j].charAt(k)) {
                        continue;
                    } else {                        
                        flag = false;
                        break;
                    }
                }
                if(flag) {       
                    //System.out.println(banned_id[i] + " " +user_id[j]);
                    id[i].add(user_id[j]);
                }
            }
        }    
        comb(0, id);
        return result;
    }
    
    public static void comb(int idx, ArrayList<String>[] id) {
        if(idx == id.length) {
            String check = "";
            for(String str : set) {
                check += str;
            }
            if(checkSet.contains(check)) {
                return;
            }
            result++;
            checkSet.add(check);
            return;
        }
        ArrayList<String> idList = id[idx];
        for(int i = 0; i < idList.size(); i++) {
            String idStr = idList.get(i);
            if(set.contains(idStr)) {
                continue;
            }
            set.add(idStr);
            comb(idx + 1, id);
            set.remove(idStr);
        }
    }
}