package study_210104;

import java.util.HashMap;

public class Programmers_42579 {

    //베스트앨범
    public static void main(String[] args){
        String[] genres = {"classic","pop","classic","classic","pop"};
        int[] plays = {500,600,150,800,2500};

        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            if(!map.containsKey(genres[i])){
                map.put(genres[i],plays[i]);
            }else{
                map.put(genres[i],map.get(genres[i])+plays[i]);
            }
        }

        String[] keys = new String[map.size()];
        int pos = 0;
        for(String key:map.keySet()){
            keys[pos] = key;
            pos++;
        }


    }
}
