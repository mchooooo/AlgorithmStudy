package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://www.acmicpc.net/problem/11000
 */
public class 강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] sp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sp[0]);
            arr[i][1] = Integer.parseInt(sp[1]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);

        for (int i = 1; i < N; i++) {
            if (arr[i][0] >= pq.peek()) {
                pq.poll();
                pq.add(arr[i][1]);
            } else {
                pq.add(arr[i][1]);
            }
        }

        System.out.println(pq.size());


    }
}
