package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/22251
 */
public class 빌런호석 {

    static int[][] MAP = {
        {1, 1, 1, 0, 1, 1, 1}, // 0
        {0, 0, 1, 0, 0, 1, 0}, // 1
        {1, 0, 1, 1, 1, 0, 1}, // 2
        {1, 0, 1, 1, 0, 1, 1}, // 3
        {0, 1, 1, 1, 0, 1, 0}, // 4
        {1, 1, 0, 1, 0, 1, 1}, // 5
        {1, 1, 0, 1, 1, 1, 1}, // 6
        {1, 0, 1, 0, 0, 1, 0}, // 7
        {1, 1, 1, 1, 1, 1, 1}, // 8
        {1, 1, 1, 1, 0, 1, 1}  // 9
    };

    private static int diff(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            if (MAP[x][i] != MAP[y][i]) cnt++;
        }

        return cnt;
    }

    private static int[] padding(int n, int K) {
        int[] d = new int[K];
        for (int i = 0; i < K; i++) {
            d[i] = n % 10;
            n /= 10;
        }
        return d;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int N = Integer.parseInt(sp[0]);
        int K = Integer.parseInt(sp[1]);
        int P = Integer.parseInt(sp[2]);
        int X = Integer.parseInt(sp[3]);

        int[] curr = padding(X, K);
        int ans = 0;

        for (int floor = 1; floor <= N; floor++) {
            if (floor == X) continue;

            int[] target = padding(floor, K);
            int reverse = 0;
            for (int i = 0; i < K; i++) {
                reverse += diff(curr[i], target[i]);
                if (reverse > P) {
                    break;
                }
            }

            if (1 <= reverse && reverse <= P) {
                ans++;
            }

        }

        System.out.println(ans);

    }
}
