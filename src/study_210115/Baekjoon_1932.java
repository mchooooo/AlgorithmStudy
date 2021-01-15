package study_210115;

import java.util.Scanner;

//정수 삼각형
public class Baekjoon_1932 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;

        int[][] arr = new int[n+1][n+1];

        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j <= i; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j <= i; j++){
                arr[i][j] = Math.max(arr[i-1][j-1]+arr[i][j],arr[i-1][j]+arr[i][j]);
                if(max < arr[i][j]) max = arr[i][j];
            }
        }

        System.out.println(max);

    }

}
