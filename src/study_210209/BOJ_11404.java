package study_210209;

import java.util.Scanner;

public class BOJ_11404 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+1][n+1];

        for(int i = 1; i <= m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            if(arr[x][y] != 0){
                arr[x][y] = Math.min(arr[x][y],z);
            }else{
                arr[x][y] = z;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                if(i!=j && arr[i][j]==0){
                    arr[i][j] = 100000000;
                }
            }
        }

        //플로이드 워샬
        for(int k = 1; k <=n; k++){
            for(int i = 1; i <= n; i++){
                for(int j =1; j <= n; j++){
                    if(i!=k && j!=k && j!= i) {
                        arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j]==100000000) arr[i][j] = 0;
            }
        }

        for(int i = 1; i <=n;i++){
            for(int j=1; j<=n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}




