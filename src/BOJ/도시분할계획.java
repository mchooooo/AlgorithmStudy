package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 도시분할계획 {

    static class Town implements Comparable<Town> {
        int s;
        int e;
        int cost;
        public Town(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        public int compareTo(Town t) {
            return Integer.compare(this.cost, t.cost);
        }

    }

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);

        parent = new int[n+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int max = 0;
        PriorityQueue<Town> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            sp = br.readLine().split(" ");
            int s = Integer.parseInt(sp[0]);
            int e = Integer.parseInt(sp[1]);
            int cost = Integer.parseInt(sp[2]);

            pq.add(new Town(s,e,cost));
//            pq.add(new Town(e,s,cost));
        }

        int answer = 0;


        while(!pq.isEmpty()) {
            Town t = pq.poll();

            if (!isSameParent(t.s, t.e)) {
                answer += t.cost;
                union(t.s, t.e);
                max = Math.max(max, t.cost);
                // 2 - 3 - 1   4 - 6
            }

        }

        System.out.println(answer - max);

    }

    private static boolean isSameParent(int x, int y) {
        x = getParent(x);
        y = getParent(y);

        return x==y;
    }

    private static void union(int x, int y) {
        x = getParent(x);
        y = getParent(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static int getParent(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = getParent(parent[x]);
    }

}
