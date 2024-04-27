class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling) {            
            int index = 0;
            int num = 0;
            while(index <= word.length()) {
                if(index == word.length()) {
                    answer++;
                    break;
                }
                
                if(index+3 <= word.length()&&word.substring(index, index+3).equals("aya")&& num!=1) {
                    index += 3;
                    num = 1;
                } else if(index+3 <= word.length() && word.substring(index, index+3).equals("woo")&&num!=2) {
                    index += 3;
                    num = 2;
                } else if(index+2 <= word.length() && word.substring(index, index+2).equals("ye")&&num!=3) {
                    index += 2;
                    num = 3;
                } else if(index+2 <= word.length() &&word.substring(index, index+2).equals("ma")&&num!=4) {
                    index += 2;
                    num = 4;
                } else {
                    break;
                }
            }
            
        }
        
        return answer;
    }
}