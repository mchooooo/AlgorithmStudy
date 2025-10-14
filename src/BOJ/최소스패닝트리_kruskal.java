package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소스패닝트리_kruskal {

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;
        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }
    }

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int v = Integer.parseInt(sp[0]);
        int e = Integer.parseInt(sp[1]);

        parent = new int[v+1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            sp = br.readLine().split(" ");
            int start = Integer.parseInt(sp[0]);
            int end = Integer.parseInt(sp[1]);
            int cost = Integer.parseInt(sp[2]);
            pq.add(new Edge(start,end,cost));
        }

        int answer = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (!isSameParent(edge.start, edge.end)) {
                union(edge.start, edge.end);
                answer += edge.cost;
            }

        }

        System.out.println(answer);

    }

    private static void union(int x, int y) {
        x = getParent(x);
        y = getParent(y);

        if (x < y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

    private static int getParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    private static boolean isSameParent(int x, int y) {
        x = getParent(x);
        y = getParent(y);
        return x == y;
    }

}
