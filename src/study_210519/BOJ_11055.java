package study_210519;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11055 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] info = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(info[i]);
        }
        int[] dp = new int[n];

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            dp[i] = arr[i];
            for(int j = 0; j < i; j++){
                if(arr[j]<arr[i] && dp[i] < dp[j] + arr[i]){
                    dp[i] = dp[j] + arr[i];
                }
            }
            max = Math.max(max,dp[i]);
        }



        System.out.println(max);

    }
}
