package study_210317;

/*
* 퇴사
* DP
*  P[i] = Math.max(P[i+1], P[i] + P[i+T[i]]);
* 맥스값을 가져서 리턴은 아니고 출력
* */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_14501 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] T = new int[17];
        int[] P = new int[17];
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = n; i >= 1; i--) {
            if (i + T[i] > n + 1) P[i] = P[i+1];
            else {
                P[i] = Math.max(P[i+1], P[i] + P[i+T[i]]);
                max = Math.max(max, P[i]);
            }
        }

        System.out.println(P[1]);

    }

}
