package study_210223;

import java.util.Scanner;
//dp로 풀어야한대요 ㅋㅋ
public class BOJ_11053 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i = 1; i < arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for(int i = 1; i < arr.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i]>arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j]+1;
//                    print(dp);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);

//        Arrays.sort(arr);
//        int cnt = 0;
//        int cur = Integer.MIN_VALUE;
//        for(int i = 0; i<arr.length; i++){
//            if(cur < arr[i]){
//                cur = arr[i];
//                cnt++;
//            }
//        }
//        System.out.println(cnt);

    }
    public static void print(int[] dp){
        for(int i = 1; i < dp.length; i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
}
