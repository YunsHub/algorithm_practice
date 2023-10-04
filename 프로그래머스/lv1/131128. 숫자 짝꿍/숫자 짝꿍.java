import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < X.length(); i++) xArr[X.charAt(i) - '0']++;
        for(int i = 0; i < Y.length(); i++) yArr[Y.charAt(i) - '0']++;
        
        for(int i = 0; i < 10; i++) {
            int cnt = 0;
            if(xArr[i] != 0 && yArr[i] != 0) cnt = Math.min(xArr[i], yArr[i]);
            for(int j = 0; j < cnt; j++) list.add(i);            
        }
        Collections.sort(list, Collections.reverseOrder());
        if(list.size() == 0) return "-1";
        else if(list.get(0) == 0) return "0";
        for(int num : list) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}