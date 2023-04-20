class Solution {
    public int solution(int price) {
        double result = 0L;
        if(price >= 500_000) {
            result = price * 0.8;
        } else if(price >= 300_000) {
            result = price * 0.9;
        } else if(price >= 100_000) {
            result = price * 0.95;
        } else {
            result = price;
        }
        
        return (int)result;
    }
}