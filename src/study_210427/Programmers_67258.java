package study_210427;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Programmers_67258 {
    public static void main(String[] args) {

        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
        int[] answer = new int[2];
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }

        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int distance = Integer.MAX_VALUE;
        while(true){
            if(map.size() == set.size()){
                //더 좋은 답인지 확인?
                map.put(gems[left], map.get(gems[left])-1);
                if(map.get(gems[left])==0) map.remove(gems[left]);
                left++;
            }else if(right == gems.length) break;
            else{
                if(!map.containsKey(gems[right])) map.put(gems[right], 1);
                else map.put(gems[right], map.get(gems[right])+1);
                right++;
            }
            if (map.size() == set.size()) {
                if (right-left < distance){
                    distance = right-left;
                    start = left+1;
                    end = right;
                }
            }
        }

        answer[0] = start;
        answer[1] = end;
        System.out.println(answer[0] + " / " + answer[1]);


    }
}
