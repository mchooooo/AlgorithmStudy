package study_201121;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//프로그래머스 레벨1 나누어 떨어지는 숫자 배열
public class Level01_12910 {

    public static void main(String[] args){

        int[] arr = {5,9,7,10};
        int divisor = 5;
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i]%divisor == 0){
                list.add(arr[i]);
            }
        }

        if(list.size()==0){
            list.add(-1);
        }

        answer = new int[list.size()];

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

    }

}
