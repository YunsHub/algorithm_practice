import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        k--;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        
        int[] answer = new int[n];
        int idx = 0;
        while(n>0) {
            long total = factorial(n);
            long div = total / n;            
            long index = k / div;
            
            
            k = k % div;
            
            answer[idx++] = list.remove((int) index);
            n--;
        }
        
        return answer;
        
    }
    
    public long factorial(long n) {
        if(n<=1) return n;
        return factorial(n-1) * n;
    }
}