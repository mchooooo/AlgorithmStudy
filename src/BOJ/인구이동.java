package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/16234
 */
public class 인구이동 {

    static class Node {
        int x;
        int y;


        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[][] arr;
    static boolean[][] chk;

    static int N, L, R;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        N = Integer.parseInt(inp[0]);
        L = Integer.parseInt(inp[1]);
        R = Integer.parseInt(inp[2]);

        arr = new int[N][N];


        for (int i = 0; i < N; i++) {
            inp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(inp[j]);
            }
        }

        int answer = 0;

        while (true) {
            boolean moved = false;
            chk = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!chk[i][j]) {
                        List<Node> nodes = bfs(i, j, chk);
                        if (nodes.size() > 1) {
                            moved = true;
                            int sum = 0;

                            for (Node n : nodes) {
                                sum += arr[n.x][n.y];
                            }

                            int avg = sum / nodes.size();
                            for (Node n : nodes) {
                                arr[n.x][n.y] = avg;
                            }

                        }
                    }
                }
            }

            if (!moved) {
                break;
            }

            answer++;
        }

        System.out.println(answer);

    }

    private static List<Node> bfs(int x, int y, boolean[][] visit) {
        visit[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        List<Node> nation = new ArrayList<>();

        q.add(new Node(x, y));
        nation.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (visit[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(arr[curr.x][curr.y] - arr[nx][ny]);

                if (L > diff || diff > R) {
                    continue;
                }

                visit[nx][ny] = true;
                q.add(new Node(nx, ny));
                nation.add(new Node(nx, ny));
            }
        }

        return nation;
    }


    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void print(boolean[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
