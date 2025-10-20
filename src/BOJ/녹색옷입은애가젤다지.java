package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4485
 */
public class 녹색옷입은애가젤다지 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }

    }

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int answer = Integer.MAX_VALUE;
    private static int[][] arr;
    private static boolean[][] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            arr = new int[n][n];
            chk = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer t = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(t.nextToken());
                }
            }

            int answer = dijkstra(n);
            sb.append("Problem ").append(tc++).append(": ").append(answer).append("\n");

        }

        System.out.println(sb);
    }

    private static int dijkstra(int n) {
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, 100000000);
        }

        dist[0][0] = arr[0][0];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, arr[0][0]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (dist[curr.x][curr.y] < curr.cost) {
                continue;
            }

            if (curr.x == n - 1 && curr.y == n - 1) {
                return curr.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (!isValid(nx, ny)) {
                    continue;
                }

                int nc = curr.cost + arr[nx][ny];

                if (nc < dist[nx][ny]) {
                    dist[nx][ny] = nc;
                    pq.add(new Node(nx, ny, nc));
                }

            }
        }

        return arr[n - 1][n - 1];

    }


    private static boolean isValid(int x, int y) {
        return x >= 0 && x < arr.length && y >= 0 && y < arr.length;
    }

    private static void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
