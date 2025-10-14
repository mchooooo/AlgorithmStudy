package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/13549
 */
public class 숨박꼭질3 {
    static class Pos {
        int start;
        int second;

        public Pos(int start, int second) {
            this.second = second;
            this.start = start;
        }

    }

    static int answer = 0;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");

        int x = Integer.parseInt(inp[0]);
        int k = Integer.parseInt(inp[1]);
        chk = new boolean[1000000];
        chk[x] = true;

        bfs(x, k);

        System.out.println(answer);

    }

    private static void bfs(int x, int k) {
        Deque<Pos> q = new LinkedList<>();
        q.add(new Pos(x, 0));

        while (!q.isEmpty()) {

            Pos curPos = q.poll();

            if (curPos.start == k) {
                answer = curPos.second;
                break;
            }

            int dx = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    dx = curPos.start * 2;
                    if (dx <= 100000 && !chk[dx]) {
                        chk[dx] = true;
                        q.addFirst(new Pos(dx, curPos.second));
                    }

                } else if (i == 1) {
                    dx = curPos.start - 1;
                    if (dx < 0) {
                        continue;
                    }
                    if (!chk[dx]) {
                        chk[dx] = true;
                        q.add(new Pos(dx, curPos.second + 1));
                    }
                } else {
                    dx = curPos.start + 1;
                    if (!chk[dx]) {
                        chk[dx] = true;
                        q.add(new Pos(dx, curPos.second + 1));
                    }
                }
            }
        }

    }
}
