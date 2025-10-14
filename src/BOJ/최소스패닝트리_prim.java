package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 최소스패닝트리_prim {

    static class Edge implements Comparable<Edge> {
        int e;
        int weight;
        Edge (int e, int weight) {
            this.e = e;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

    }

    static boolean[] chk;
    static List<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int v = Integer.parseInt(sp[0]);
        int e = Integer.parseInt(sp[1]);
        chk = new boolean[v+1];
        graph = new ArrayList[v+1];

        for (int i = 0; i < v+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            sp = br.readLine().split(" ");
            int start = Integer.parseInt(sp[0]);
            int end = Integer.parseInt(sp[1]);
            int weight = Integer.parseInt(sp[2]);
            graph[start].add(new Edge(end, weight));
            graph[end].add(new Edge(start,weight));
        }


        prim(1);


    }

    private static void prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));
        int answer = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (chk[edge.e]) {
                continue;
            }

            chk[edge.e] = true;

            answer+=edge.weight;
            for (Edge e : graph[edge.e]) {
                if (!chk[e.e]) {
                    pq.add(e);
                }
            }

        }

        System.out.println(answer);

    }
}
