package study_210211;

import java.util.Arrays;

public class Programmers_12941 {
    public static void main(String[] args){
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        Arrays.sort(A);
        Arrays.sort(B);
        //124 345
        int[][] dp = new int[A.length+1][A.length+1];
        int answer = 1;

        for(int i = 0; i < A.length; i++){
            dp[0][i+1] = A[i];
            dp[i+1][0] = B[i];
        }

        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= A.length;j++){
                dp[i][j] = dp[i][0] * dp[0][j];
            }
        }

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

    }
}
