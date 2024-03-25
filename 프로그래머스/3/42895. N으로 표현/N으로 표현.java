import java.util.*;
class Solution {
    public int solution(int N, int number) {
        List<HashSet<Integer>> numberList = new ArrayList<>();
        for(int index = 0; index <= 8; index++) {
            numberList.add(new HashSet<Integer>());
        }
        numberList.get(1).add(N);
        if(number == N) return 1;
        
        for(int listIndex = 2; listIndex <= 8; listIndex++) {
            HashSet<Integer> numberSet = numberList.get(listIndex);
            
            for(int setIndex = 1; setIndex < listIndex; setIndex++) {
                HashSet<Integer> aSet = numberList.get(setIndex);
                HashSet<Integer> bSet = numberList.get(listIndex - setIndex);
                for(int x : aSet) {
                    for(int y : bSet) {
                        numberSet.add(x + y);
                        numberSet.add(x - y);
                        numberSet.add(x * y);
                        if(x != 0 && y != 0) numberSet.add(x / y);
                    }
                }
            }
            int sum = 0;
            for(int cnt = 0; cnt < listIndex; cnt++) {
                sum = (sum * 10) + N;
            }
            if(sum <= 32000) numberSet.add(sum);
            if(numberSet.contains(number)) return listIndex;        
        }
        
        return -1;
    }
}