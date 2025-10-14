package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/1446
 */
public class 지름길 {
    static class Shortcut implements Comparable<Shortcut> {
        int start;
        int end;
        int dist;

        public Shortcut(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Shortcut s) {
            return Integer.compare(this.start, s.start);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int D = Integer.parseInt(inp[1]);

        List<Shortcut>[] shortcuts = new ArrayList[10001];
        for (int i = 0; i < 10001; i++) {
            shortcuts[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            inp = br.readLine().split(" ");
            int start = Integer.parseInt(inp[0]);
            int end = Integer.parseInt(inp[1]);
            int dist = Integer.parseInt(inp[2]);

            if (end > D) {
                continue;
            }

            if (end - start > dist) {
                shortcuts[start].add(new Shortcut(start, end, dist));
            }

        }

        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < D + 1; i++) {

            if (i + 1 <= D) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }

            for (Shortcut s : shortcuts[i]) {
                dp[s.end] = Math.min(dp[s.end], dp[i] + s.dist);
            }

        }

        System.out.println(dp[D]);

    }
}
