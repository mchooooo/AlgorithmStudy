package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/20922
 */
public class 겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int K = Integer.parseInt(inp[1]);

        inp = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] map = new int[100001];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }


        int answer = 0;

        int left = 0, right = 0, max = 0;
        while (right < N) {
            int var = arr[right];
            map[var]++;

            while (map[var] > K) {
                map[arr[left]]--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
            right++;

        }

//        int temp = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = i; j < N; j++) {
//                if (map[arr[j]] >= K) {
//                    break;
//                }
//
//                map[arr[j]]++;
//                temp++;
//
//            }
//
//            answer = Math.max(answer, temp);
//            temp = 0;
//            map = new int[100001];
//        }

        System.out.println(answer);

    }
}
