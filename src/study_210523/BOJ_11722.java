package study_210523;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11722 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        String[] info = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(info[i]);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] < arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);

    }
}
