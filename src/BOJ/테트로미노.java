package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 테트로미노 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] chk;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);

        arr = new int[n][m];
        chk = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            sp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(sp[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                chk[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                chk[i][j] = false;
            }
        }

        System.out.println(answer);

    }

    private static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx,ny) && !chk[nx][ny]) {

                if (depth == 2) {
                    chk[nx][ny] = true;
                    dfs(x, y, sum + arr[nx][ny], depth + 1);
                    chk[nx][ny] = false;
                }

                chk[nx][ny] = true;
                dfs(nx, ny, sum + arr[nx][ny], depth + 1);
                chk[nx][ny] = false;

            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

}
