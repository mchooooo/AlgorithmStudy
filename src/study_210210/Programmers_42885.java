package study_210210;

import java.util.Arrays;

public class Programmers_42885 {
    public static void main(String[] args){
        int[] people={50,70,80,50};
        int limit = 100;
        int answer = 0;
        Arrays.sort(people);

        //50 50 70 80
        int left = 0;
        int right = people.length-1;
        while(left <= right){//0 3, 0 2, 0 1, 1 0
            int temp = people[right--]; //80 3, 70 2, 50 1,
            if(temp + people[left] <= limit ) left++;//1
            answer++;
        }

        System.out.println(answer);
    }
}
