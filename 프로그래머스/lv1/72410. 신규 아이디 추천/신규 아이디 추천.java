class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        
        // 1단계 대문자 -> 소문자
        sb.append(new_id.toLowerCase());
        
        // 2단계 일부 특수 문자 제거
        for(int index = 0; index < sb.length(); index++) {
            char word = sb.charAt(index);            
            if((97 <= word && 122 >= word) || (word >= 48 && word <= 57) ||
               word == '-' || word == '_' || word == '.') continue;            
            sb.deleteCharAt(index);
            index--;
        }
        
        // 3단계 마침표 연속 제거
        String str = sb.toString();
        while(str.contains("..")) {
            str = str.replace("..", ".");
        }
        sb = new StringBuilder();
        sb.append(str);
        
        // 4단계 처음, 끝 . 제거
        if(sb.charAt(0) == '.') sb.deleteCharAt(0);
        if(sb.length() > 1 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        
        // 5단계 빈 문자열이라면 "a"대입
        if(sb.toString().equals("")) sb.append("a");
        
        // 6단계 16자 이상이면 뒤에 문자 자르고 마지막이 "."이면 제거
        
        if(sb.length() >= 16) {
            String subStr = sb.substring(0, 15);
            if(subStr.charAt(subStr.length() - 1) == '.') {                
                subStr = subStr.substring(0, 14);
            }
            sb = new StringBuilder();
            sb.append(subStr);
        }
        
        // 7단계 2자 이하라면 마지막 문자를 길이 3이상 될때까지 붙이기
        if(sb.length() <= 2) {
            char word = sb.charAt(sb.length() - 1);
            while(sb.length() < 3) {
                sb.insert(sb.length() - 1, word);
            }
        }
               
        return sb.toString();
    }
}