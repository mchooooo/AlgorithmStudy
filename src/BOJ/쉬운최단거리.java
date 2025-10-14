package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/14940
 */
public class 쉬운최단거리 {

    static class Node{
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int n;
    static int m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int[][] answer;
    static boolean[][] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        n = Integer.parseInt(inp[0]);
        m = Integer.parseInt(inp[1]);

        arr = new int[n][m];
        chk = new boolean[n][m];

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            inp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(inp[j]);
                if (arr[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!chk[i][j] && arr[i][j] == 1) {
                    arr[i][j] = -1;
                }
            }
        }

        print();
    }
    private static void bfs(int x, int y) {
        arr[x][y] = 0;
        chk[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            arr[node.x][node.y] = node.dist;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (isValid(nx, ny) && arr[nx][ny] != 0 && !chk[nx][ny]) {
                    chk[nx][ny] = true;
                    q.add(new Node(nx, ny, node.dist + 1));

                }
            }

        }

    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
