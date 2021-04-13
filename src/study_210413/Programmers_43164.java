package study_210413;

import java.util.*;

public class Programmers_43164 {
    static Map<String, PriorityQueue<String>> map;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args){

        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        map = new HashMap<>();
        for(String[] ticket : tickets){
            if(!map.containsKey(ticket[0])){
                map.put(ticket[0],new PriorityQueue<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        dfs("ICN");
        String[] answer = new String[list.size()];
        Collections.reverse(list);
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }


    }
    public static void dfs(String departure){
        PriorityQueue<String> pq = map.get(departure);
        while (pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        list.add(departure);
    }
}
