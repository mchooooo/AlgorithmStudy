package study_210225;

import java.util.*;

public class Programmers_64065 {
    public static void main(String[] args){

        int[] answer = {};
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

//        s = s.replace("{","");
//        s = s.replace("}","");
//        System.out.println(s);
//        String[] temp = s.split(",");
//        Map<String,Integer> map = new HashMap<>();
//        System.out.println("---------------");
//
//        for(int i = 0; i < temp.length; i++){
//            if(!map.containsKey(temp[i])){
//                map.put(temp[i],Integer.parseInt(temp[i]));
//                System.out.println(temp[i]);
//            }
//        }
//
//        answer = new int[map.size()];
//        int pos = 0;
//        System.out.println("------------");
//        for(int i : map.values()){
//
//            System.out.println(i);
//            answer[pos++] = i;
//        }

        s = s.substring(1,s.length()-1);
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        String item = "";
        boolean flag = false;
        int dotCnt = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                flag = true;
                continue;
            }

            if(ch == '}'){
                pq.add(new Tuple(item,dotCnt+1));
                flag = false;
                item = "";
                dotCnt = 0;
                continue;
            }
            if(flag){
                item += ch;
                if(ch == ',') {
                    dotCnt++;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            String[] temp = t.item.split(",");
            for(int i = 0; i < temp.length; i++){
                if(!list.contains(Integer.parseInt(temp[i]))){
                    list.add(Integer.parseInt(temp[i]));
                }
            }

        }
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
    }
}
class Tuple implements Comparable<Tuple>{
    String item;
    int len;
    Tuple(String item, int len){
        this.item = item;
        this.len = len;
    }

    @Override
    public int compareTo(Tuple o){
        return Integer.compare(this.len, o.len);
    }
}