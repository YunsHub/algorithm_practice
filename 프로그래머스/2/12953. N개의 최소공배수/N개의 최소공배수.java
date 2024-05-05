class Solution {
    public int solution(int[] arr) {        
        
        if(arr.length == 1) return arr[0];
        
        int num = (arr[0] * arr[1]) / gcd(arr[0], arr[1]);
        
        
        for(int i=2; i<arr.length; i++) {
            num = (num * arr[i]) / gcd(num, arr[i]);
        }
        
        return num;
    }
    
    public int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}