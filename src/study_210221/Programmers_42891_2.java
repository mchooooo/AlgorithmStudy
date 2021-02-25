package study_210221;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 가장 적은 시간 걸리는 음식 = 시간 * 사이클
* 우선순위 큐를 통해 음식 정렬 ??
* Food 클래스를 만들어서 인덱스랑 먹는 시간 저장
* */
class Food implements Comparable<Food>{
    int time;
    int index;
    public Food(int time, int index){
        this.time = time;
        this.index = index;
    }

    @Override
    public int compareTo(Food o){
        return Integer.compare(this.time,o.time);
    }


}
public class Programmers_42891_2 {
    public static void main(String[] args){
        int[] food_times = {4,2,3,6,7,1,5,8};
        //0 0 0 1 3 0 1 4
        long k = 27;

        int answer = 0;
        int sum = 0;

        for(int i : food_times){
            sum += i;
        }
        //음식 먹는데 걸리는 시간이 K보다 작으면 -1
        if(sum <= k) answer = -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();
        Comparator<Food> cmp_index = (a,b)->{ return a.index-b.index; };
        PriorityQueue<Food> que_index = new PriorityQueue<>(cmp_index);

        for(int i = 0; i < food_times.length; i++){
            pq.add(new Food(food_times[i],i));
        }
        //1 2 3 4 5 6 7 8
        // 음식 시간 * 사이클해서 사이클 길이보다 작을 때 까지
        long curTime = 0;

        while(true){
            Food f = pq.peek();
            //걸린시간 계산
            long spendTime = (f.time - curTime) * pq.size();

            //걸린 시간이 k 보다 작으면 음식을 다 먹은 것
            if(spendTime < k){
                food_times[f.index] = 0;
                k -= spendTime;
                curTime = f.time;
                pq.poll();
            //걸린시간이 k보다 커지면 반복문 나가야하지 않나요?
            }else{
                //다음 먹을 음식 탐색
                k %= pq.size();
                k++;
                que_index.addAll(pq);
                for(int i = 0; i < k; i++){
                    Food food = que_index.poll();
                    answer = food.index+1;
                }
                break;
            }
        }

        for(Food f : que_index){
            System.out.println(f.time +" / "+ f.index);
        }
        System.out.println(answer);

    }

}
