package tmax_2023;

import java.util.*;

/*
* https://school.programmers.co.kr/learn/courses/15009/lessons/121688
* [PCCP 모의고사 #2] 2번 - 신입사원 교육
* */
public class Programmers_PCCP2_2 {

    public static void main(String[] args) {
        int[][] ability = {{10,3,7,2}, {1,2,3,4}};
        int[] number = {2,3};
        for (int i = 0; i < 2; i++) {
            System.out.println(solution(ability[i], number[i]));
        }
    }
    public static int solution(int[] ability, int number) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : ability) {
            pq.add(i);
        }

        for (int i = 0; i < number; i++) {
            int min = pq.poll() + pq.poll();
            pq.add(min);
            pq.add(min);
        }

        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        return answer;
    }
}
