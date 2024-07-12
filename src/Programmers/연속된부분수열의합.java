package Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 연속된부분수열의합 {
    public static void main(String[] args) {
        int[][] s = {
            {1, 2, 3, 4, 5},
            {1, 1, 1, 2, 3, 4, 5},
            {2, 2, 2, 2, 2}
        };
        int[] k = {7,5,6};

        for (int i = 0; i < s.length; i++) {
            int[] answer = solution2(s[i], k[i]);

            for(int j : answer) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        long sum = 0;

        while (true) {

            if (sum >= k) {
                if (sum == k && length > right - left) {
                    length = right - left;
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                sum -= sequence[left++];
            } else {
                if (right == sequence.length) break;
                sum += sequence[right++];
            }

        }


        return answer;
    }

    public static int[] solution2(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        long sum = sequence[0];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.size));

        while(true) {
            if (sum == k) {
                pq.add(new Node(left, right));
            }

            if (left == sequence.length && right == sequence.length) {
                break;
            }

            if (sum <= k && right < sequence.length) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left];
                left++;
            }


        }

        Node n = pq.poll();
        answer[0] = n.left;
        answer[1] = n.right;

        return answer;
    }

    static class Node {
        int left;
        int right;
        int size;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }
    }

}
