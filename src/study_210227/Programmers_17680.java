package study_210227;

import java.util.LinkedList;
import java.util.Queue;

/*
* 캐시
* LRU 방식으로 처리 : 페이지 부재가 발생했을 경우 가장 오랫동안 사용되지 않은 페이지를 제거하는 알고리즘
* 1. 캐시 크기에 맞게 Queue사용
* 2. queue.poll -> 페이지 부재
* 3. queue.add -> 새로 넣을 때
* 만약 히트하면 빼서 다시 넣음
* */
public class Programmers_17680 {
    public static void main(String[] args){

        int cacheHit = 1;
        int cacheMiss = 5;

        int answer = 0;
        int cacheSize = 0;

        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        if(cacheSize == 0){
            System.out.println("return "+cities.length * cacheMiss);
        }
        Queue<String> q = new LinkedList<>();

        for(int i = 0; i < cities.length; i++){
            if(q.size() < cacheSize){
                if(q.contains(cities[i].toLowerCase())){
                    answer += cacheHit;
                    q.remove(cities[i].toLowerCase());
                    q.add(cities[i].toLowerCase());
                    System.out.println(1);
                    continue;
                }
                q.add(cities[i].toLowerCase());
                answer += cacheMiss;
            }else{
                if(q.contains(cities[i].toLowerCase())){
                    q.remove(cities[i].toLowerCase());
                    q.add(cities[i].toLowerCase());
                    answer += cacheHit;
                    System.out.println(2);
                }else{
                    q.poll();
                    q.add(cities[i].toLowerCase());
                    answer += cacheMiss;
                    System.out.println(3);
                }
            }
        }

        System.out.println(answer);

    }
}
