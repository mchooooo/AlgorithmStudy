package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
https://www.acmicpc.net/problem/1987
 */
public class 알파벳 {

    static char[][] arr;
    static boolean[][] chk;
    static int answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        arr = new char[n][m];
        chk = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        Set<Character> set = new HashSet<>();
        set.add(arr[0][0]);
        chk[0][0] = true;
        dfs(0,0, set);

        System.out.println(answer);

    }

    private static void dfs(int x, int y, Set<Character> set) {
        answer = Math.max(answer, set.size());

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && !set.contains(arr[nx][ny])) {
                set.add(arr[nx][ny]);
                dfs(nx, ny, set);
                set.remove(arr[nx][ny]);
            }

        }

    }

    private static boolean isValid(int nx, int ny) {
        return nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length;
    }

}
