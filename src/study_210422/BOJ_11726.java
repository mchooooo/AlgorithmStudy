package study_210422;

import java.util.Scanner;

/*
* 2*1 / 2*2 / 2*3
* dp[0] = 0
* dp[1] = 1
* dp[2] = 2
* dp[3] = 3
* dp[n] = dp[n-1] + dp[n-2]
* */
public class BOJ_11726 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        if(N <= 3) {
            System.out.println(dp[N]);
            System.exit(0);
        }
        for(int i =4; i <= N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[N]);
    }
}
