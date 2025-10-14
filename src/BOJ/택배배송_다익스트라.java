package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/5972
 */
public class 택배배송_다익스트라 {

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public Edge(int end, int cost) {
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
        String[] inp = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);

        List<Edge>[] graph = new List[N + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            inp = br.readLine().split(" ");
            int s = Integer.parseInt(inp[0]);
            int e = Integer.parseInt(inp[1]);
            int c = Integer.parseInt(inp[2]);

            graph[s].add(new Edge(e, c));
            graph[e].add(new Edge(s, c));
        }


        //다익스트라
        // 시작은 무조건 1번
        int[] answer = new int[N + 1];
        Arrays.fill(answer, 10000);
        answer[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();

            // 현재 노드보다 이미 찾은 값이 더 작은 경우에는 탐색 종료
            if (answer[curEdge.end] < curEdge.cost) {
                continue;
            }

            for (Edge next : graph[curEdge.end]) {
                if (answer[curEdge.end] + next.cost < answer[next.end]) {
                    answer[next.end] = answer[curEdge.end] + next.cost;
                    pq.add(new Edge(next.end, answer[next.end]));
                }
            }

        }

        System.out.println(answer[N]);






    }
}
