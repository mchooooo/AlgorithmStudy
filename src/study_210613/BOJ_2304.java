package study_210613;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);
        int answer = 0;
        int left = 0;
        int right = n - 1;
        int leftMax = list.get(0).height;
        int rightMax = list.get(n - 1).height;
        int leftIdx = list.get(0).left;
        int rightIdx = list.get(n - 1).left;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            leftMax = Math.max(leftMax, list.get(left).height);
            rightMax = Math.max(rightMax, list.get(right).height);
            max = Math.max(max, Math.max(rightMax, leftMax));
            if (leftMax > rightMax) {
                right -= 1;
                if (list.get(right).height > rightMax) {
                    answer += (rightIdx - list.get(right).left) * rightMax;
                    rightIdx = list.get(right).left;
                }
//                System.out.println("# " + answer);
            } else {

                left += 1;
                if (list.get(left).height > leftMax) {
                    answer += (list.get(left).left - leftIdx) * leftMax;
                    leftIdx = list.get(left).left;
                }
//                System.out.println("@ "+answer);
            }
        }
        answer += (rightIdx - leftIdx + 1) * max;
        System.out.println(answer);


    }
}

class Node implements Comparable<Node> {
    int left;
    int height;

    public Node(int left, int height) {
        this.left = left;
        this.height = height;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(this.left, n.left);
    }
}
