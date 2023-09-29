class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] now = new int[2];
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    now[0] = i;
                    now[1] = j;
                }
            }
        }
        for(int i = 0; i < routes.length; i++) {
            char dir = routes[i].charAt(0);
            int dis = routes[i].charAt(2) - '0';
            if(move(park, now, dir, dis)) {
                if(dir == 'E') now[1] += dis;
                else if(dir == 'W') now[1] -= dis;
                else if(dir == 'S') now[0] += dis;
                else now[0] -= dis;
            }
            
        }
                
        return now;
    }
    
    public boolean move(String[] park, int[] now, char dir, int dis) {
        boolean check = true;
        if(dir == 'E') {
            if(now[1] + dis >= park[now[0]].length()) return false;
            for(int i = now[1]; i <= now[1] + dis; i++) {
                if(park[now[0]].charAt(i) == 'X') return false;
            }
        } else if(dir == 'W') {
            if(now[1] - dis < 0) return false;
            for(int i = now[1]; i >= now[1] - dis; i--) {
                if(park[now[0]].charAt(i) == 'X') return false;
            }
        } else if(dir == 'S') {
            if(now[0] + dis >= park.length) return false;
            for(int i = now[0]; i <= now[0] + dis; i++) {
                if(park[i].charAt(now[1]) == 'X') return false;
            }
        } else {
            if(now[0] - dis < 0) return false;
            for(int i = now[0]; i >= now[0] - dis; i--) {
                if(park[i].charAt(now[1]) == 'X') return false;
            }
        }
        return true;
    }
}