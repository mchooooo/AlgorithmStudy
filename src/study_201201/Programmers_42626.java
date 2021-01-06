package study_201201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//프로그래머스 레벨2 더 맵게
public class Programmers_42626 {
    public static void main(String[] args){
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }

        int size = pq.size();
        int answer = 0;
        for(int i = 0; i < size; i++){
            if(pq.peek() >= K || pq.size() < 2) break;
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+(b*2));
            answer++;
        }
        if(pq.peek()<K) System.out.println(-1);
        System.out.println(answer);

    }
}
