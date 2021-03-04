package study_210303;

import java.util.Scanner;

/*
* 줄세우기
* 증가하는 최장 수열을 찾음 LIS
* answer = arr.length - LIS
* */
public class BOJ_2631 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        int max = 0;
        //LIS 알고리즘
        for(int i = 1; i <= n; i++){
            dp[i] = 1;
            for(int j = 1; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j]+1){
                    dp[i]++;
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(n-max);

    }
}
