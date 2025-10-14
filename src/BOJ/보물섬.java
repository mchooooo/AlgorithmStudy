package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 보물섬 {

    static class Land {
        int x;
        int y;
        int time;
        public Land(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static char[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);

        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'L') {
                    boolean[][] chk = new boolean[n][m];
                    bfs(i,j,chk);
                }
            }
        }

        System.out.println(time);


    }

    private static void bfs(int x, int y, boolean[][] chk) {
        chk[x][y] = true;
        Queue<Land> q = new LinkedList<>();
        q.add(new Land(x, y, 0));
        int t = 0;
        while(!q.isEmpty()) {
            Land l = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = l.x + dx[i];
                int ny = l.y + dy[i];

                if (isValid(nx, ny) && arr[nx][ny] == 'L' && !chk[nx][ny]) {
                    chk[nx][ny] = true;
                    q.add(new Land(nx,ny, l.time + 1));
                }

            }

            time = Math.max(time, l.time);

        }


    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < arr.length && y >= 0 && y < arr[0].length;
    }
}
