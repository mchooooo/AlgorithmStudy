package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://acmicpc.net/problem/14503
 */
public class 로봇청소기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int N = Integer.parseInt(sp[0]);
        int M = Integer.parseInt(sp[1]);

        sp = br.readLine().split(" ");
        int x = Integer.parseInt(sp[0]); // 처음 로봇 청소기 x 위치
        int y = Integer.parseInt(sp[1]); // 처음 로봇 청소기 y 위치
        int d = Integer.parseInt(sp[2]); // 로봇 청소기 방향

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            sp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(sp[j]);
            }
        }

        // d == 0 -> 북, d == 1 -> 동, d == 2 -> 남, d == 3 -> 서
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int answer = 0;

        while (true) {
            if (arr[x][y] == 0) { // 현재 칸이 청소되지 않았으면 청소
                answer += 1;
                arr[x][y] = 2; // 청소 표시

            }

            int rotate = 0;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (isValid(nx, ny, N, M)) {
                    if (arr[nx][ny] == 0) {
                        x = nx;
                        y = ny;
                        break;
                    } else {
                        rotate++;

                    }
                }
            }

            if (rotate == 4) {
                int nx = x - dx[d];
                int ny = y - dy[d];

                if (isValid(nx, ny, N, M)) {
                    if (arr[nx][ny] == 1) {
                        break;
                    } else if (arr[nx][ny] != 1) {
                        x = nx;
                        y = ny;
                    }
                }
            }

        }

        System.out.println(answer);




    }

    private static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

}
