package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inp = br.readLine().split(" ");
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = N - 1;

        int best = Integer.MAX_VALUE;

        // |arr[right]| - |arr[left]|
        // -5 -4 -3 1 2 99
        while (left < right) {
            int sum = arr[left] + arr[right];
            int abs = Math.abs(sum);

            if (abs < best) {
                best = abs;
                result.clear();
                result.add(arr[left]);
                result.add(arr[right]);
                if (best == 0) break;
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }

        }

        Collections.sort(result);
        System.out.print(result.get(0) + " " + result.get(1));
    }
}
