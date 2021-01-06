package study_201115;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Level01_moegosa {
    public static void main(String[] args){
        int[] answers = {1,3,2,4,2};
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] answer = {};
        int[] result = new int[3];

        for(int i = 0; i < answers.length;i++){
            if(answers[i]==one[i%one.length]){
                result[0] += 1;
            }
            if(answers[i]==two[i%two.length]){
                result[1] += 1;
            }
            if(answers[i]==three[i%three.length]){
                result[2] +=1;
            }
        }

        List<Integer> list = new ArrayList<>();

        int max = Math.max(result[0],Math.max(result[1],result[2]));
        if(max == result[0]) list.add(1);
        if(max == result[1]) list.add(2);
        if(max == result[2]) list.add(3);

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }





    }
}
