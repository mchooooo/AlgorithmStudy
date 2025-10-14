package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://www.acmicpc.net/problem/1202
 */
public class 보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sp = br.readLine().split(" ");
        int N = Integer.parseInt(sp[0]);
        int K = Integer.parseInt(sp[1]);
        int[][] juwel = new int[N][2];
        int[] bag = new int[K];
        long answer = 0;

        for (int i = 0; i < N; i++) {
            sp = br.readLine().split(" ");
            juwel[i][0] = Integer.parseInt(sp[0]);
            juwel[i][1] = Integer.parseInt(sp[1]);
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        // 보석 정렬 낮은 무게, 무게가 같다면 가치가 높은걸로
        Arrays.sort(juwel, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        // 가방 오른차순 정렬
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int idx = 0;
        for (int b : bag) {

            while (idx < N && juwel[idx][0] <= b) {
                pq.add(juwel[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();

            }



        }

        System.out.println(answer);

    }
}
