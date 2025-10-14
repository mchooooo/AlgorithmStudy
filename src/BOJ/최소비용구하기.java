package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1916
 */
public class 최소비용구하기 {
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new List[n+1];
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 데이터 넣기
        String[] inp = null;
        for (int i = 0; i < m; i++) {
            inp = br.readLine().split(" ");
            int start = Integer.parseInt(inp[0]);
            int end = Integer.parseInt(inp[1]);
            int cost = Integer.parseInt(inp[2]);

            graph[start].add(new Edge(start, end, cost));
        }

        inp = br.readLine().split(" ");
        int startEdge = Integer.parseInt(inp[0]);
        int endEdge = Integer.parseInt(inp[1]);

        int[] answer = new int[n+1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        answer[startEdge] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startEdge, startEdge, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (e.cost > answer[e.end]) {
                continue;
            }

            for (Edge next : graph[e.end]) {
                if (answer[next.end] > answer[e.end] + next.cost) {
                    answer[next.end] = answer[e.end] + next.cost;
                    pq.add(new Edge(next.start, next.end, answer[next.end]));
                }
            }

        }

        System.out.println(answer[endEdge]);

    }
}
