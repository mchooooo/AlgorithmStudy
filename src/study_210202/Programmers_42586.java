package study_210202;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_42586{

    public static void main(String[] args){
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            q.add((100-progresses[i]) % speeds[i] == 0 ? (100-progresses[i])/speeds[i] : ((100-progresses[i])/speeds[i]) + 1);
        }

        List<Integer> list = new ArrayList<>();
        int prevFunc = q.poll();
        int numOfFunc = 1;

        while(!q.isEmpty()){
            int conFunc = q.poll();
            if(prevFunc >= conFunc){
                numOfFunc++;
            }else{
                list.add(numOfFunc);
                numOfFunc=1;
                prevFunc = conFunc;
            }
        }
        list.add(numOfFunc);
        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size();i++){
            answer[i] = list.get(i);
        }

        for(int i : answer){
            System.out.println(i);
        }
        

    }

}
