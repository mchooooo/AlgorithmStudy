package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1260
 */
public class DFS와BFS {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int v;
    static int[][] arr;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");

        n = Integer.parseInt(inp[0]);
        m = Integer.parseInt(inp[1]);
        v = Integer.parseInt(inp[2]) - 1;

        arr = new int[n][n];
        chk = new boolean[n];

        int x = 0;
        int y = 0;

        for (int i = 0; i < m; i++) {
            inp = br.readLine().split(" ");
            arr[Integer.parseInt(inp[0]) - 1][Integer.parseInt(inp[1]) - 1] = 1;
            arr[Integer.parseInt(inp[1]) - 1][Integer.parseInt(inp[0]) - 1] = 1;

            if (i + 1 == v) {
                x = Integer.parseInt(inp[0]) - 1;
                y = Integer.parseInt(inp[1]) - 1;
            }
        }

        chk[v] = true;
//        print();
        dfs(v);
        System.out.println();
        chk = new boolean[n];
        chk[v] = true;
        bfs(v);

    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + 1 + " ");

            for (int i = 0; i < n; i++) {
                if (arr[curr][i] == 1 && !chk[i]) {
                    q.add(i);
                    chk[i] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            System.out.print(q.poll() + 1 + " ");
        }

    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int start) {
        chk[start] = true;
        System.out.print(start + 1 + " ");

        for (int i = 0; i < n; i++) {
            if (arr[start][i] == 1 && !chk[i]) {
                dfs(i);
            }
        }

    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

}
