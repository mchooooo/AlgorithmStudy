package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/*
https://www.acmicpc.net/problem/11660
 */
public class 구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sp = br.readLine().split(" ");

        int N = Integer.parseInt(sp[0]);
        int M = Integer.parseInt(sp[1]);
        int[][] arr = new int[N+1][N+1];
        int[][] sum = new int[M][4];

        for (int i = 0; i < N; i++) {
            sp = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                arr[i+1][j+1] = Integer.parseInt(sp[j]);
            }
        }

        for (int i = 0; i < M; i++) {
            sp = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                sum[i][j] = Integer.parseInt(sp[j]);
            }
        }

        int[][] dp = new int[N+1][N+1];

        // 누적합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = sum[i][0];
            int y1 = sum[i][1];
            int x2 = sum[i][2];
            int y2 = sum[i][3];

            System.out.println(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1-1] + dp[x1 - 1][y1 - 1]);

        }

    }
}
