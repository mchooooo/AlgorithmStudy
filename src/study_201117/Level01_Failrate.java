package study_201117;

import java.util.*;

public class Level01_Failrate {
    public static void main(String[] args){
        int N = 4;
        int[] stages = {4,4,4,4,4};
        int[] answer = new int[N];
        float[] fail = new float[N];

        Map<Integer,Integer> map = new HashMap<>();
        int user = stages.length;

        for(int i = 0; i <stages.length; i++){
            if(!map.containsKey(stages[i])){
                map.put(stages[i],1);
            }else{
                map.put(stages[i],map.get(stages[i])+1);
            }
        }

        List<Node> list = new ArrayList<>();
        for(int i =1 ; i <= N; i++){
            Node n = new Node();
            n.pos = i;
            if(map.get(i)==null) {
                n.rate = 0;
            }else{
                n.rate = map.get(i) / (float) user;
                user -= map.get(i);
            }
            list.add(n);
        }

        for(int i =0 ; i<N;i++){
            answer[i] = findMax(list).pos;
        }

        for(int i =0 ; i<N;i++){
            System.out.println(answer[i]);
        }

    }
    public static Node findMax(List<Node> list){
        float max = 0;
        for(int i = 0; i < list.size();i++) {
            max = Math.max(max,list.get(i).rate);
        }
        Node n = new Node();
        for(int i = 0; i < list.size(); i++){
            if(max == list.get(i).rate) {
                n = list.get(i);
                list.get(i).rate = Integer.MIN_VALUE;
                break;
            }
        }

        return n;
    }
}

class Node{
    int pos;
    float rate;
}