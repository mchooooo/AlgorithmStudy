package Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 연속펄스부분수열의합 {
    public static void main(String[] args) {
        int[][] s = {
            {2, 3, -6, 1, 3, -1, 2, 4}
        };

        for (int i = 0; i < s.length; i++) {
            System.out.println(solution(s[i]));
        }
    }

    public static long solution(int[] sequence) {
        long answer = 0;
        long[][] dp = new long[sequence.length + 1][2];

        for (int i = 1; i < sequence.length + 1; i++) {
            int num = sequence[i-1];
            if (i % 2 == 1) {
                dp[i][0] = num;
                dp[i][1] = num * -1;
            } else {
                dp[i][0] = num * -1;
                dp[i][1] = num;
            }

            if (dp[i][0] < dp[i - 1][0] + dp[i][0]) {
                dp[i][0] += dp[i-1][0];
            }

            if (dp[i][1] < dp[i-1][1] + dp[i][1]) {
                dp[i][1] += dp[i-1][1];
            }

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        return answer;
    }
}
