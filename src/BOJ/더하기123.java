package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15989
 */
public class 더하기123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[10001];
        dp[0] = 1;

        for (int num = 1; num < 4; num++) { // 1, 2, 3 선택
            for (int i = num; i < 10001; i++) { //
                dp[i] += dp[i - num];
            }
        }

        for (int answer : arr) {
            System.out.println(dp[answer]);
        }

    }
}
