package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2512
 */
public class 예산_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int budget = Integer.parseInt(br.readLine());
        int max = Arrays.stream(arr).max().getAsInt();
        int min = 0;
        int answer = 0;

        if (Arrays.stream(arr).sum() <= budget) {
            System.out.println(max);
            return;
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += Math.min(arr[i], mid);
            }

            if (count == budget) {
                answer = mid;
                break;
            }

            if (count < budget) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }

        }

        System.out.println(answer);
    }
}
