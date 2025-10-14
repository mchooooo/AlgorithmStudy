package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
    https://www.acmicpc.net/problem/1931
 */
public class 회의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) { //종료시간이 같다
                return Integer.compare(o1[0],o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });

        int cnt = 1;
        int end = arr[0][1];

        for (int i = 1; i < n; i++) {
            if (end <= arr[i][0]) {
                end = arr[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
