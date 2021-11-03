package study_210703;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];

        int answer = 0;

        int maxIdx = 0;
        // 10 20 10 30 20 50
        for(int i = 0; i < n; i++){
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i]++;
                }
            }
            answer = Math.max(answer, dp[i]);

        }
        //14002 문제
        for(int i = 0; i < arr.length; i++){
            if(dp[i] == answer){
                maxIdx = i;
            }
        }
        int max = answer;
        List<Integer> list = new ArrayList<>();

        while(maxIdx >= 0){
            if(max == dp[maxIdx]){
                list.add(arr[maxIdx]);
                max--;
            }
            maxIdx--;
        }

        System.out.println(answer);
        for(int i = list.size()-1; i >= 0; i--){
            System.out.print(list.get(i)+" ");
        }

    }
}
