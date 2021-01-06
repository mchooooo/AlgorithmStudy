package study_201229;

import java.util.Scanner;

public class Baekjoon_2644 {

    static int[][] arr;
    static int x;
    static int y;
    static int result;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        int m = sc.nextInt();

         arr = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

//        print();
        dfs(x,0,0);
        if(result!=0){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }

    public static void dfs(int a,int q,int cnt){
        if(a==y){
            result = cnt;
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[a][i]==1 && i!=q) {
                dfs(i,a,cnt+1);
            }
        }
    }

    public static void print(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}

