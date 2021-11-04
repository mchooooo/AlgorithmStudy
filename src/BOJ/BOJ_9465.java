package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9465 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n > 0){
            int col = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][col+1];
            String[] str;
            for(int i = 0; i <2; i++){
                str = br.readLine().split(" ");
                for(int j = 1; j < col+1; j++){

                    arr[i][j] = Integer.parseInt(str[j-1]);
                }
            }
            int[][] dp = new int[2][col+1];
            dp[1][1] = arr[1][1];
            dp[0][1] = arr[0][1];

            for(int i = 2; i <= col; i++){
                dp[0][i] = Math.max(dp[1][i-2],dp[1][i-1])+arr[0][i];
                dp[1][i] = Math.max(dp[0][i-2],dp[0][i-1])+arr[1][i];
            }

            System.out.println(Math.max(dp[0][col],dp[1][col]));

            n--;
        }


    }
}
