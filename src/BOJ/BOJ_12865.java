package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ_12865 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);
        int[][] arr = new int[n+1][k+1];
        for(int i = 1; i <= n; i++){
            info = br.readLine().split(" ");
            int w = Integer.parseInt(info[0]);
            int v = Integer.parseInt(info[1]);
            for(int j = 1; j <= k; j++){
                arr[i][j] = arr[i-1][j];
                if(j-w >= 0){
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-w]+v);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=k; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(arr[n][k]);



    }

}
