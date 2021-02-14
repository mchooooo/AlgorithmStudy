package study_210211;

import java.util.Arrays;

public class Programmers_12941 {
    public static void main(String[] args){
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        Arrays.sort(A);
        Arrays.sort(B);
        //124 345

        int answer = 0;

        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[B.length-1-i];
        }
        System.out.println(answer);

    }
}
