package study_210413;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
* 야근 지수
* pq를 이용해서 제일 높은 것 일빼고 다시 넣고
* n번 반복
* */
public class Programmers_12927 {
    public static void main(String[] args){
        int[] works = {1,1};
        int n = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
        for(int i = 0; i < works.length; i++){
            pq.add(works[i]);
        }

        for(int i = 0; i < n; i++){
            int t = pq.poll();
            if (t <= 0 ) t = 0;
            else t -= 1;
            pq.add(t);
        }

        long sum = 0;
        for(int i = 0; i < works.length; i++){
            sum += Math.pow(pq.poll(),2);
        }
        System.out.println(sum);


    }
}
