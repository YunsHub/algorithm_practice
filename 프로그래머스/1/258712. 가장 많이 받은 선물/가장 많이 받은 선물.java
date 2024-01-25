import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // friends[]:친구 이름, gifts[]:선물 기록
        // 다음달에 가장 많은 선물을 받는 친구의 선물 개수 return
        
        // 1. 이번달에 선물을 더 많이 준사람이 다음달에 선물을 받는다.
        // 2. 이번달에 선물을 주고받은 개수가 같거나 하나도 주고받지 
        // 않는다면 선물지수가 낮은 사람이 높은 사람에게 선물을 준다.
        // 선물지수 : 모든 친구들에게 준 선물 개수 - 모든 친구들에게 받은 선물 개수
        // 3. 선물지수가 같으면 다음달에 선물을 주고받지 않는다.
        
        // HashMap을 사용하여 친구들을 0번부터 index로 저장
        // 2차원 배열에 주고받은 선물 내역 저장
        // 선물지수 구하기
        
        
        // init
        int answer = 0;
        Map<String, Integer> friendsMap = new HashMap<>();
        int len = friends.length;
        int[][] giftList = new int[len][len];
        int[] giftScore = new int[friends.length];
        
        for(int i=0; i<len; i++) {
            friendsMap.put(friends[i], i);
        }
        
        // 주고 받은 선물 리스트
        for(String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            int friend_1 = friendsMap.get(st.nextToken());
            int friend_2 = friendsMap.get(st.nextToken());
            
            giftList[friend_1][friend_2]++;
        }
        
        // 선물 지수
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                giftScore[i] += giftList[i][j];
                giftScore[j] -= giftList[i][j];
            }
        }
        
        // 다음달 선물 가장 많이 받는 친구 선물 개수
        for(int i=0; i<len; i++) {
            int nextMonthGift = 0;
            for(int j=0; j<len; j++) {
                if(i==j) continue;
                
                if(giftList[i][j] > giftList[j][i]) {
                    nextMonthGift++;
                } else if(giftList[i][j] == giftList[j][i]) {
                    if(giftScore[i] > giftScore[j]) {
                        nextMonthGift++;
                    }
                }
            }
            
            answer = Math.max(answer, nextMonthGift);
        }
        
        return answer;
    }
}