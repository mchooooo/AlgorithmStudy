package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1946
 */
public class 신입사원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

            int cnt = 1;
            int num = arr[0][1];

            for (int j = 1; j < n; j++) {
                if (num > arr[j][1]) {
                    cnt++;
                    num = arr[j][1];
                }
            }

            System.out.println(cnt);

        }
    }
}
