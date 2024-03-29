package BOJ;

import javax.management.openmbean.SimpleType;
import java.util.Scanner;

/*
*   RGB거리
*   dp
* */
public class BOJ_1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i-1][0] + arr[i][1], dp[i-1][0] + arr[i][2]);
            dp[i][1] = Math.min(dp[i-1][1] + arr[i][0], dp[i-1][0] + arr[i][2]);
            dp[i][2] = Math.min(dp[i-1][1] + arr[i][1], dp[i-1][0] + arr[i][2]);
        }


        int min = Math.min(dp[n-1][0], Math.min(dp[n-1][1],dp[n-1][2]));
        System.out.println(min);

    }
}
