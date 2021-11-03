package study_210520;

import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int[] dp = new int[5001];
        dp[0] = 0;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for(int i = 6; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                dp[i] = dp[i-5]+1;
            }else if(i%3 == 0) dp[i] = dp[i-3]+1;
            else if(i % 5 == 0) dp[i] = dp[i-5] +1;
            else if(dp[i-3] != -1 && dp[i-5] != -1){
                dp[i] = Math.min(dp[i-3]+1,dp[i-5]+1);
            }else{
                dp[i] = -1;
            }
        }
        System.out.println(dp[n]);

    }
}
