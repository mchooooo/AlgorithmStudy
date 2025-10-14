package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 방탈출 {

    static class Node {
        int x;
        int y;
        int distance;
        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int answer = 0;
    static int distance = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            sp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(sp[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    boolean[][] chk = new boolean[n][m];
                    bfs(i,j,chk);
                }
            }
        }

        System.out.println(answer);

    }

    private static void bfs(int x, int y, boolean[][] chk) {
        chk[x][y] = true;
        Queue<Node> pq = new LinkedList<>();
        pq.add(new Node(x, y, 0));
        int start = arr[x][y];
        int a = 0;
        int b = 0;
        int c = 0;
        while(!pq.isEmpty()) {
            Node n = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if (isValid(nx, ny) && !chk[nx][ny] && arr[nx][ny] != 0) {
                    chk[nx][ny] = true;
                    pq.add(new Node(nx, ny, n.distance + 1));
                }
            }

//            if (n.distance >= distance) {
//                distance = n.distance;
//                System.out.println(distance + " / " + x + " / " + y + " / " + n.x + " / " + n.y);
//                answer = Math.max(answer, arr[n.x][n.y] + start);
//                System.out.println(answer);
//            }
            a = n.x;
            b = n.y;
            c = n.distance;
        }


        if (c >= distance) {
//            System.out.println(x +" / " + y + " / " + a + " / " + b + " / " + c);
            if (c > distance) {
                answer = start + arr[a][b];
            } else {
                answer = Math.max(answer, start + arr[a][b]);
            }
            distance = c;
        }

    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < arr.length && y >= 0 && y < arr[0].length;
    }
}
