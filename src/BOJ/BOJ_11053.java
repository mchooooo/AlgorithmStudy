package BOJ;

import java.util.Scanner;

/*
* 증가하는 가장 긴 수열
* LIS
* dp
* */
public class BOJ_11053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];

        /*
        * 10 20 10 30 20 50
        * 1  2  1  3  2  4
        * */
        dp[0] = 1;
        int max = 0;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j <= i; j++){
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);

        }
        for(int i : dp){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(max);

    }

}
