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
        HashMap<String, Integer> stream = new HashMap<>();
        for(int index = 0; index < genres.length; index++) {
            stream.put(genres[index], stream.getOrDefault(genres[index], 0) + plays[index]);
        }
        
        ArrayList<Music> musicList = new ArrayList<>();
        for(String key : stream.keySet()) {
            musicList.add(new Music(key, stream.get(key)));        
        }
        Collections.sort(musicList);
        
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