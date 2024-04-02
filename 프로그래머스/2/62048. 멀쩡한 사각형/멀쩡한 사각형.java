import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long line = gcd(w,h);
        long nw = w / line;
        long nh = h / line;
        long lw = w;
        long lh = h;
        long answer = lw * lh - ((nw + nh - 1) * line);
        return answer;
    }
    
    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}