import java.util.*;

class Solution {
    // 0 1 0 1
    // 0 0 0 1
    // 1 1 0 0
    // 0 0 0 0
    // Map으로 id에 인덱스 부여
    // 2차원 배열에 신고 현황 저장
    // 신고 받은 횟수가 k이상이면 1차원 배열에 인덱스 저장
    // 신고 현황을 돌면서 체크
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> idMap = new HashMap<>();
        int len = id_list.length;
        int[] answer = new int[len];
        boolean[][] reportArr = new boolean[len][len];
        boolean[] reportId = new boolean[len];
        
        // init
        for(int i=0; i<len; i++) {
            idMap.put(id_list[i], i);
        }
        
        for(String id : report) {
            StringTokenizer st = new StringTokenizer(id);
            int reporter = idMap.get(st.nextToken());
            int reported = idMap.get(st.nextToken());
            reportArr[reporter][reported] = true;
        }
        
        // 정지 아이디
        for(int i=0; i<len; i++) {
            int reportCnt = 0;
            for(int j=0; j<len; j++) {
                if(reportArr[j][i]) {
                    reportCnt++;
                }
            }
            
            if(reportCnt >= k) reportId[i] = true;
        }
        
        // 정지 신고 성공
        for(int i=0; i<len; i++) {
            int cnt = 0;
            for(int j=0; j<len; j++) {
                if(reportArr[i][j] && reportId[j]) {
                    cnt++;
                }
            }
            
            answer[i] = cnt;
        }
        
        return answer;
    }
}