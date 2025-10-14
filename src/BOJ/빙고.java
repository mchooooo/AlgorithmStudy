package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 빙고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[5][5];
        boolean[][] chk = new boolean[5][5];
        int[] talk = new int[25];
        for (int i = 0; i < 5; i++) {
            String[] sp = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(sp[j]);
            }
        }

        int pos = 0;

        for (int i = 0; i < 5; i++) {
            String[] sp = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                talk[pos++] = Integer.parseInt(sp[j]);
            }
        }

        for (int i = 0; i < talk.length; i++) {
            int cnt = bingo(talk[i], arr, chk);
            if (cnt >= 3) {
//                System.out.println(talk[i]);
                System.out.println(i+1);
                break;
            }
        }


    }

    private static int bingo(int num, int[][] arr, boolean[][] chk) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == num) {
                    chk[i][j] = true;
                    int cnt = 0;
                    cnt += chkRow(chk);
                    cnt += chkCol(chk);
                    cnt += chkCrossLeft(chk);
                    cnt += chkCrossRight(chk);
                    if (cnt >= 3) {
                        return cnt;
                    }
                }
            }
        }

        return 0;
    }

    private static int chkCrossRight(boolean[][] chk) {
        int cnt = 0;
        int x = 0;
        int y = 4;
        for (int i = 0; i < 5; i++) {
            if (chk[x++][y--]) {
                cnt++;
            }
        }

        return cnt == 5 ? 1 : 0;

    }

    private static int chkCrossLeft( boolean[][] chk) {
        int cnt = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 5; i++) {
            if (chk[x++][y++]) {
                cnt++;
            }
        }
        return cnt == 5 ? 1 : 0;
    }

    private static int chkCol(boolean[][] chk) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int temp = 0;
            for (int j = 0; j < 5; j++) {
                if (chk[j][i]) {
                    temp++;
                }
            }

            if (temp == 5) {
                cnt++;
            }
        }

        return cnt;
    }

    private static int chkRow(boolean[][] chk) {
        int cnt = 0;

        for (boolean[] row : chk) {
            int temp = 0;
            for (int i = 0; i < 5; i++) {
                if (row[i]) {
                    temp++;
                }
            }

            if (temp == 5) {
                cnt++;
            }
        }

        return cnt;

    }

}
