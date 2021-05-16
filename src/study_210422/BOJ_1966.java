package study_210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1966 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N != 0){
            String[] sp = br.readLine().split(" ");
            int size = Integer.parseInt(sp[0]);
            int target = Integer.parseInt(sp[1]);
            sp = br.readLine().split(" ");
            int answer = 1;
            int count = 0;
            PriorityQueue priority = new PriorityQueue<>(Collections.reverseOrder());
            int[] priorities = new int[size];
            for(int i = 0; i < size; i++){
                priorities[i] = Integer.parseInt(sp[i]);
            }

            for(int task : priorities){
                priority.add(task);
            }

            count = print(priority, priorities, count, answer, target);

            System.out.println(count);
            N--;

        }
    }
    public static int print(PriorityQueue<Integer> priority, int[] priorities, int count, int answer, int target){
        while(!priority.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)priority.peek()) {
                    if(i == target){
                        return answer;
                    }
                    priority.poll();
                    answer++;
                }
            }
        }
        return 0;
    }
}

