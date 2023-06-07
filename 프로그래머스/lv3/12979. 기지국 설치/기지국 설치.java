class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // boolean visited[] = new boolean[n + 1];
        int start = 1;
        int end = 1;
        for(int i = 0; i < stations.length; i++) {
            int place = stations[i];
            end = place - w;
            if(end - start > 0) {
                answer += (end - start) / (w * 2 + 1);   
                if((end - start) % (w * 2 + 1) != 0) {
                     answer += 1;
                }
            }                   
            start = place + w + 1;       
        }
        end = n;
        System.out.println(start);
        if(end - start > 0) {
            answer += (end - start) / (w * 2 + 1);
            if((end - start) % (w * 2 + 1) != 0) {
                 answer += 1;
            }
        } else if(end == start) {
            answer += 1;
        }
        
        
        // int cnt = 0;
        // for(int i = 1; i <= n; i++) {
        //     if(!visited[i]) {
        //         cnt++;
        //     } else {
        //         answer += (cnt / (w * 2 + 1));
        //         if(cnt % (w * 2 + 1) != 0) {
        //             answer += 1;
        //         }
        //         cnt = 0;
        //     }
        // }
        // answer += (cnt / (w * 2 + 1));
        // if(cnt % (w * 2 + 1) != 0) {
        //     answer += 1;
        // }
        
        return answer;
    }
}