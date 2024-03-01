import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int a = getNum(arrayA, arrayB);
        int b = getNum(arrayB, arrayA);
        
        return Math.max(a, b);
    }
    
    public int getNum(int[] arrayA, int[] arrayB) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=arrayA[0]; i>=2; i--) {//
            boolean check = true;
            
            for(int n : arrayA) {
                if(n % i != 0) {
                    check = false;
                    break;    
                }
            }
            if(check) list.add(i);
        }
        
        return checkNum(list, arrayB);
    }
    
    public int checkNum(List<Integer> list, int[] arrayB) {
        
        for(int n : list) {
            boolean check = true;
            for(int i=0; i<arrayB.length; i++) {
                if(arrayB[i] % n == 0) {
                    check = false;
                    break;
                }
            }  
            
            if(check) {
                return n;
            }
        }
        
        return 0;
    }
    
    
}