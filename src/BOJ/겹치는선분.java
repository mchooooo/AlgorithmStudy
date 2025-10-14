package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
https://www.acmicpc.net/problem/1689
 */
public class 겹치는선분 {
    static class Node { // 선분의 시작점, 끝점 저장하는 클래스
        int point;
        int value;

        Node(int point, int value) {
            this.point = point;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N 입력 받음
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" "); // 선분 입력
            list.add(new Node(Integer.parseInt(s[0]), 1));
            list.add(new Node(Integer.parseInt(s[1]), -1));
        }

        // 시작점 기준으로 sort
        list.sort((o1, o2) -> {
            if (o1.point == o2.point) {
                return Integer.compare(o1.value, o2.value);
            }
            return Integer.compare(o1.point, o2.point);
        });


        int cnt = 0;
        int answer = 0;

        for (Node n : list) {
            cnt += n.value;
            answer = Math.max(cnt, answer);
        }

        for (Node n : list) {
            System.out.println(n.point + " / " + n.value);
        }

        System.out.println(answer);

    }
}
