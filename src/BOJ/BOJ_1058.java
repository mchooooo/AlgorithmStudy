package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
* 1. 플로이드-와샬
* */
public class BOJ_1058 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                if(i==j) arr[i][j] = 0;
                else if(ch == 'Y')arr[i][j] = 1;
                else arr[i][j] = 1000000;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(i == j || j==k || i==k) continue;
                    if(arr[i][j] + arr[j][k] < arr[i][k]){
                        arr[i][k] = arr[i][j] + arr[j][k];
                    }
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(i==j) continue;
                if(arr[i][j] <= 2){
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
//        print(arr);

    }
    public static void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
