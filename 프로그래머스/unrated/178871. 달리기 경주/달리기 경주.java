import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        HashMap<Integer, String> rankMap = new HashMap<>();
        for(int index = 0; index < players.length; index++) {
            playerMap.put(players[index], index);
            rankMap.put(index, players[index]);
        }
        for(int index = 0; index < callings.length; index++) {
            int nowRank = playerMap.get(callings[index]);
            String nowPlayer = rankMap.get(nowRank);            
            String frontPlayer = rankMap.get(nowRank - 1);
            
            playerMap.put(nowPlayer, nowRank - 1);
            rankMap.put(nowRank - 1, nowPlayer);
            
            playerMap.put(frontPlayer, nowRank);
            rankMap.put(nowRank, frontPlayer);            
        }
        
        String[] answer = new String[players.length];
        int answerIdx = 0;
        for(int key : rankMap.keySet()) {
            answer[answerIdx++] = rankMap.get(key);
        }
        
        return answer;
    }
}