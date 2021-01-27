package study_210127;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_42583 {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {7,4,5,6};
        System.out.println(solution.solution(2,10,arr));
    }


}

class Solution{
    public int solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;
        int sumOfWeight = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int t : truck_weights){
            for(int i = 0; i < truck_weights.length; i++){
                if(q.isEmpty()){
                    q.add(t);
                    sumOfWeight += t;
                    answer++;
                    break;
                }else if(q.size()==bridge_length){

                    sumOfWeight -= q.poll();
                }else{
                    if(sumOfWeight + t > weight){
                        answer++;
                        q.add(0);
                    }else{
                        q.add(t);
                        sumOfWeight += t;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer+bridge_length;
    }
}
