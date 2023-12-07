package tmax_2023;

import java.util.Arrays;

/*
* https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/?envType=daily-question&envId=2023-11-07
* 1921. Eliminate Maximum Number of Monsters
* */
public class Leetcode_1921 {
    public static void main(String[] args) {
        int[][] dist = {{1,3,4}, {1,1,2,3}, {3,2,4}};
        int[][] speed = {{1,1,1}, {1,1,1,1}, {5,3,2}};

        for (int i = 0; i < dist.length; i++) {
            System.out.println(solution(dist[i], speed[i]));
        }
    }

    private static int solution(int[] dist, int[] speed) {
        // 몬스터의 도착시간을 계산 dist / speed
        // sort 수행
        // 하나씩 뽑으면서 0보다 작거나 같으면 lose
        // 0보다 크면 result++
        int result = 0;
        double[] arrive = new double[dist.length];

        for (int i = 0; i < dist.length; i++) {
            arrive[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(arrive);
        for (int i = 0; i < dist.length; i++) {
            if (arrive[i] <= i) { // 몬스터가 도착한 경우
                break;
            }
            result++;
        }

        return result;

    }
}
