package study_210121;

import java.util.Scanner;

//바이러스 DFS
public class Baekjoon_2606 {
    public static int[][] arr;
    public static boolean[][] checked;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int computer = sc.nextInt();
        int network = sc.nextInt();

        arr = new int[computer+1][computer+1];
        checked = new boolean[computer+1][computer+1];

        for(int i = 0; i<network; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int i = 1; i<=1;i++ ){
            for(int j = 1; j < arr.length; j++){
                if(arr[i][j]==1 && !checked[i][j]){
                    checked[i][j] = true;
                    dfs(j);
                }
            }
        }
        int cnt = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[1][i]==1) cnt++;
        }
        System.out.println(cnt-1);

//        for(int i = 1; i <= 1; i++){
//            for(int j = 1; j < arr.length; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void dfs(int row){



        for(int i=1; i<arr.length; i++){
            if(arr[row][i]==1 && !checked[row][i]){
                checked[row][i] = true;
                arr[1][i] = 1;
                dfs(i);

            }
        }


    }
}
