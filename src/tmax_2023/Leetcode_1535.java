package tmax_2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
* https://leetcode.com/problems/find-the-winner-of-an-array-game/description/?envType=daily-question&envId=2023-11-05
* 1535. Find the Winner of an Array Game
* */
public class Leetcode_1535 {
    public static void main(String[] args) {
        int[][] arr = {{2,1,3,5,4,6,7}, {3,2,1}};
        int[] k = {2, 10};

        for (int i = 0; i < k.length; i++) {
            System.out.println(solution(arr[i], k[i]));
        }
    }

    private static int solution(int[] arr, int k) {
        // 맨 앞 두 숫자 비교 후 큰 값은 맨 앞, 작은 값은 맨 뒤로 보냄
        // arr를 계속 다시 만들지 않고 Deque 자료구조 사용 맨 앞에 맨 뒤에 값을 넣을 수 있다.
        // k 번 이긴 값을 구해서 리턴

        // k가 arr 길이보다 길면 최대 값 구하면 됨 -> 따지면 버블소트 느낌? 큰 값이 제일 앞으로 오게 되는
        if (k >= arr.length) {
            return Arrays.stream(arr).max().orElse(0);
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i : arr) {
            deque.add(i);
        }

        int cnt = 0;
        int currentNum = 0;
        while (cnt != k) {
            int first = deque.pollFirst();
            int second = deque.pollFirst();

            int max = Math.max(first, second);
            int min = Math.min(first, second);

            if (max == currentNum) {
                cnt++;
            } else {
                cnt = 1;
            }

            currentNum = max;
            deque.addFirst(max);
            deque.addLast(min);
        }

        return currentNum;

    }
}
