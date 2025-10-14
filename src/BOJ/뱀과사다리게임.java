package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/16928
 */
public class 뱀과사다리게임 {
    static class Node {
        int start;
        int end;
        int cnt;

        public Node(int start, int end, int cnt) {
            this.start = start;
            this.end = end;
            this.cnt = cnt;
        }
    }

    static int[] arr;
    static boolean[] chk;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1자로 피고 생각
        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int k = Integer.parseInt(inp[1]);
        arr = new int[101];
        chk = new boolean[101];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < n + k; i++) {
            inp = br.readLine().split(" ");
            int x = Integer.parseInt(inp[0]);
            int y = Integer.parseInt(inp[1]);

            arr[x] = y;
        }

        bfs();

        System.out.println(answer);

    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0, 0));
        chk[1] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.start == 100) {
                answer = curr.cnt;
                return;
            }

            for (int i = 6; i >= 1; i--) {
                int nx = curr.start + i;
                if (nx <= 100 && !chk[nx]) {
                    chk[nx] = true;
                    q.add(new Node(arr[nx], 0, curr.cnt + 1));
                }
            }

        }

    }
}
