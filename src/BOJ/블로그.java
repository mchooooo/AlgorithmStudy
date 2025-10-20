package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21921
 */
public class 블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (Arrays.stream(arr).sum() == 0) {
            System.out.println("SAD");
            return;
        }

        int cnt = 1;
        int max = 0;
        for (int i = 0; i < x; i++) {
            max += arr[i];
        }

        int best = max;


        for (int i = x; i < n; i++) {
            max += arr[i] - arr[i - x];

            if (max > best) {
                best = max;
                cnt = 1;
            }else if (max == best) {
                cnt++;
            }
        }



        System.out.println(max);
        System.out.println(cnt);

    }
}
