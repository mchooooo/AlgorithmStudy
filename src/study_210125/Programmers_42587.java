package study_210125;

import java.util.*;

public class Programmers_42587 {

    public static void main(String[] args){
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        int answer = 1;

        PriorityQueue priority = new PriorityQueue<>(Collections.reverseOrder());

        for(int task : priorities){
            priority.add(task);
        }

        while(!priority.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)priority.peek()) {
                    if(i == location){
                        System.out.println(answer);
                    }
                    priority.poll();
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }

}
