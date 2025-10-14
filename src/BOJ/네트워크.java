package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 네트워크 {

    static class Computer implements Comparable<Computer>{
        int start;
        int end;
        int cost;
        Computer (int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Computer c) {
            return Integer.compare(this.cost, c.cost);
        }

    }

    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        String[] sp = null;
        for (int i = 0; i < M; i++) {
            sp = br.readLine().split(" ");
            int s = Integer.parseInt(sp[0]);
            int e = Integer.parseInt(sp[1]);
            int c = Integer.parseInt(sp[2]);
            pq.add(new Computer(s, e, c));
        }

        int answer = 0;

        while(!pq.isEmpty()) {
            Computer computer = pq.poll();

            if (!isSameParent(computer.start, computer.end)) {
                union(computer.start, computer.end);
                answer += computer.cost;
            }
        }

        System.out.println(answer);

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
        if (parent[x] == x) {
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
