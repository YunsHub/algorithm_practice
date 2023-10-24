import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0, size = A.length; i < size ; i++) {
            answer += (A[i] * B[size - i - 1]);
        }
        
        
        return answer;
    }
}