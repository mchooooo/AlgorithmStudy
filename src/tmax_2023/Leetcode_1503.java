package tmax_2023;

import java.util.Arrays;

/*
* https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/?envType=daily-question&envId=2023-11-04
* 1503. Last Moment Before All Ants Fall Out of a Plank
*
* */
public class Leetcode_1503 {
    public static void main(String[] args) {
        int[] n = {4,7,7};
        int[][] left = {{4,3}, {}, {0,1,2,3,4,5,6,7}};
        int[][] right = {{0,1}, {0,1,2,3,4,5,6,7}, {}};

        for (int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i], left[i], right[i]));
        }

    }

    private static int solution(int n, int[] left, int[] right) {
        // 왼쪽으로 나가는 개미 중 가장 오래걸리는 시간
        // 오른쪽으로 나가는 개미 중 가장 오래걸리는 시간을 구하고
        // 두 개중 더 긴 값을 return.
        // 방향을 바꾸는건 상관이 없음 왜냐하면 만나는 순간 방향을 바꾸게 되는데 신경쓰지 않아도 됨
        // 결국 만나는 순간 방향을 바꾸게 되면 스쳐 지나가는 것과 다르지 않다.

        // 왼쪽으로 가는 개미가 없는 경우는 0 세팅
        int leftAnt = Arrays.stream(left).max().orElse(0);
        // 오른쪽으로 가는 개미가 없는 경우 n 세팅
        int rightAnt = Arrays.stream(right).min().orElse(n);

        return Math.max(leftAnt, n - rightAnt);
    }
}
