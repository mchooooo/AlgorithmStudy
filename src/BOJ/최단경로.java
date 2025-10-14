package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1753
 */
public class 최단경로 {
    static class Node implements Comparable<Node>{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int V = Integer.parseInt(inp[0]);
        int E = Integer.parseInt(inp[1]);

        int[] dist = new int[V + 1];
        List<Node>[] graph = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < E; i++) {
            inp = br.readLine().split(" ");
            int s = Integer.parseInt(inp[0]);
            int e = Integer.parseInt(inp[1]);
            int c = Integer.parseInt(inp[2]);

            graph[s].add(new Node(e, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.end] < cur.cost) {
                continue;
            }

            for (Node next : graph[cur.end]) {
                if (dist[next.end] > dist[cur.end] + next.cost) {
                    dist[next.end] = dist[cur.end] + next.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (i == start) {
                System.out.println(0 +" ");
                continue;
            }

            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }

            System.out.println(dist[i]);

        }

    }
}
