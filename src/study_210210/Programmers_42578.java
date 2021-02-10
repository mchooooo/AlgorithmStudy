package study_210210;

import java.util.HashMap;
import java.util.Map;

public class Programmers_42578 {

    public static void main(String[] args){
        String[][] clothes = {{"a","headgear"},{"b","headgear"},{"c","eyewear"}};
        int answer =1;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            if(!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],1);
            }else{
                map.put(clothes[i][1],map.get(clothes[i][1])+1);
            }
        }

        for(int i : map.values()){
            answer *= (i+1);
        }

        System.out.println(answer-1);


    }

}
