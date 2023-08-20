import java.util.*;
class Solution {
    public class Music implements Comparable<Music>{
        int index;
        String genre;
        int plays;    
        Music(String genre, int plays) {
            this.genre = genre;
            this.plays = plays;
        }        
        Music(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }        
        @Override
        public int compareTo(Music music) {
            return music.plays - this.plays;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 plays를 구하기 위한 map 선언 후 삽입
        HashMap<String, Integer> stream = new HashMap<>();
        for(int index = 0; index < genres.length; index++) {
            stream.put(genres[index], stream.getOrDefault(genres[index], 0) + plays[index]);
        }
        
        // 정렬을 위해 ArrayList선언
        ArrayList<Music> musicList = new ArrayList<>();
        for(String key : stream.keySet()) {
            musicList.add(new Music(key, stream.get(key)));        
        }
        Collections.sort(musicList);
        
        // 총 play 수가 많은 순부터 같은 장르가 있으면 Arraylist에 넣고 정렬 후 
        // 0,1에 해당하는 인덱스 삽입 (단 size가 1일 경우엔 0번 인덱스만 삽입)
        ArrayList<Integer> albumNum = new ArrayList<>();
        for(Music music : musicList) {
            ArrayList<Music> musicPlay = new ArrayList<>();
            for(int index = 0; index < genres.length; index++) {
                if(music.genre.equals(genres[index])) {
                    musicPlay.add(new Music(index, plays[index]));
                }
            }
            Collections.sort(musicPlay);
            albumNum.add(musicPlay.get(0).index);
            if(musicPlay.size() >= 2) {
                albumNum.add(musicPlay.get(1).index);
            } 
        }
        
        int[] answer = new int[albumNum.size()];
        int index = 0;
        for(int num : albumNum) {
            answer[index++] = num;
        }
        
        return answer;
    }
}