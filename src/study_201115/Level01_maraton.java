package study_201115;

import java.util.HashMap;
import java.util.Map;

public class Level01_maraton {

    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        String[] participant = {"kiki","leo","eden"};
        String[] completion = {"eden", "kiki"};
        for(int i = 0; i < participant.length; i++){
            if(!map.containsKey(participant[i])) {
                map.put(participant[i], 1);
            }else{
                map.put(participant[i],map.get(participant[i])+1);
            }
        }

        for(int i = 0; i < completion.length; i++){
            if(map.containsKey(completion[i])){
                map.put(completion[i],map.get(completion[i])-1);
            }
        }
        String answer = "";

        for(String str : map.keySet()){
            if(map.get(str)!=0) answer = str;
        }

        System.out.println(answer);
    }
}
