package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/17615
 */
public class 볼모으기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int red = 0;
        int blue = 0;
        int cnt = 0;
        int answer = Integer.MAX_VALUE;

        for (char c : arr) {
            if (c == 'R') {
                red++;
            } else {
                blue++;
            }
        }


        // 1. R 왼쪽으로 모음
        // 왼쪽에 붙어있는 R 개수 세고 총 R 개수 - 붙어있는 R 개수
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') {
                cnt++;
            } else {
                break;
            }
        }

        answer = Math.min(answer, red - cnt);

        cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'R') {
                cnt++;
            } else {
                break;
            }
        }

        answer = Math.min(answer, red - cnt);

        cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'B') {
                cnt++;
            } else {
                break;
            }
        }

        answer = Math.min(answer, blue - cnt);
        cnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'B') {
                cnt++;
            } else {
                break;
            }
        }
        answer = Math.min(answer, blue - cnt);
        System.out.println(answer);
    }
}
