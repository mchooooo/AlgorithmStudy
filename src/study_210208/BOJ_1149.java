package study_210208;

import java.util.Scanner;

public class BOJ_1149 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N+1][4];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <=3; j++){
                arr[i][j] = sc.nextInt();
            }
        }


        for(int i = 1; i <= N; i++){
            arr[i][1] = Math.min(arr[i-1][2],arr[i-1][3]) + arr[i][1];
            arr[i][2] = Math.min(arr[i-1][1],arr[i-1][3]) + arr[i][2];
            arr[i][3] = Math.min(arr[i-1][1],arr[i-1][2]) + arr[i][3];
        }

        int min = Integer.MAX_VALUE;

        for(int i = 1; i <=3; i++){
            if(min > arr[N][i]){
                min = Math.min(min,arr[N][i]);
            }
        }
        System.out.println(min);
    }
}
