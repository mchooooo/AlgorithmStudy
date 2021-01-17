package study_210117;

import java.util.Scanner;

public class Baekjoon_9372 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T > 0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N+1][N+1];
            int cnt = 0;

            for(int i = 0; i < M; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a][b] = 1;
                arr[b][a] = 1;
            }
            System.out.println(N-1);


//            for(int i = 0; i < arr.length; i++){
//                for(int j = 0; j < arr.length; j++){
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println();
//            }

            T--;
        }

    }

}
