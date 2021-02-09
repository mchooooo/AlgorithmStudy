package study_210208;

import java.util.Scanner;

public class BOJ_12865 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr=new int[N+1][K+1];

        for(int i = 1; i <= N; i++){
            int weight = sc.nextInt();
            int value = sc.nextInt();
            for(int j = 1; j <= K; j++){
                arr[i][j] = arr[i-1][j];
                if(j-weight>=0){
                    arr[i][j] = Math.max(arr[i-1][j],arr[i-1][j-weight]+value);
                }
            }
        }

//        for(int i = 1; i <=N; i++){
//            for(int j = 1; j <=K; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(arr[N][K]);
    }
}
