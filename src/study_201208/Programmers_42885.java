package study_201208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//프로그래머스 레벨2 구명보트
public class Programmers_42885 {
    public static void main(String[] args){
        int[] people = {70,50,80,50};
        int limit = 100;

        int answer = 0;

        Arrays.sort(people);

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < people.length-1; i++){
            if(people[i]+people[i+1] <= limit) {
                list.add(people[i]+people[i+1]);
                i +=2;
            }
            else {
                list.add(people[i]);
            }
        }





        System.out.println(answer);

    }
}
