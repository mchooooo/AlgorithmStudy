package study_210210;

import java.util.Arrays;
import java.util.Collections;

public class Programmers_42747 {
    public static void main(String[] args){
        int[] citations = {3,0,1,6,5};
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);

        //01356
        for(int i = n-1; i >= 0; i--){
            if(citations[i] > answer){
                answer++;
            }else{
                break;
            }
        }
        System.out.println(answer);
    }
}
