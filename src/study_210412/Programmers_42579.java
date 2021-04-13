package study_210412;

import java.util.*;

/*
* 베스트 앨범
* 재생 순위 별로 소팅
* 가장 많이 재생된 장르 중 1, 2위
* 그 다음 장르 중 1, 2위 리턴
* */
public class Programmers_42579 {
    public static void main(String[] args){
        String[] genres = {"classic","pop","classic","classic","pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Map<String, Integer> map = new HashMap<>();
        List<Music> musicList = new ArrayList<>();
        for(int i = 0; i < genres.length; i++){
            if(!map.containsKey(genres[i])){
                map.put(genres[i], plays[i]);
            }else{
                map.put(genres[i], map.get(genres[i])+plays[i]);
            }
            musicList.add(new Music(i,plays[i], genres[i]));
        }

        Collections.sort(musicList, new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                if(o1.genre.equals(o2.genre)){
                    return o1.compareTo(o2);
                }else{
                    return -(map.get(o1.genre) - map.get(o2.genre));
                }
            }
        });

        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        Music music = musicList.get(0);
        for(int i = 0; i < musicList.size(); i++){
            if(music.genre.equals(musicList.get(i).genre)){
                if(cnt > 1) continue;
                music = musicList.get(i);
                result.add(music.idx);
                cnt++;
            }else{
                music = musicList.get(i);
                result.add(music.idx);
                cnt = 1;
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }




    }
}
class Music implements Comparable<Music>{
    int idx;
    int play;
    String genre;
    public Music(int idx, int play, String genre){
        this.idx = idx;
        this.play = play;
        this.genre = genre;
    }

    @Override
    public int compareTo(Music o){
        if(this.play == o.play){
            return this.idx - o.idx;
        } else {
            return -(this.play - o.play);
        }
    }
}
