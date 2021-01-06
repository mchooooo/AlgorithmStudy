package study_201103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingChallenge_1_1 {

    public static void main(String[] args){

        int numbers[] = {2,1,3,4,1};
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){

            for(int j = i+1; j < numbers.length; j++){
                if(!list.contains(numbers[i]+numbers[j])) {
                    list.add(numbers[i]+numbers[j]);
                }
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i<answer.length;i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);


    }
}
