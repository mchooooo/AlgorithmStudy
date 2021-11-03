package study_210614;

import java.util.Scanner;

public class BOJ_1976 {
    static int n;
    static int m;
    static int[][] map;
    static int[] dest;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 1][n + 1];
        dest = new int[m];
        visit = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    map[i + 1][j + 1] = 1;
                    map[j + 1][i + 1] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            dest[i] = sc.nextInt();
        }

        dfs(dest[0]);
        boolean check = true;
        for(int i = 0; i < m; i++){
            int c = dest[i];

            if(!visit[c]) check = false;
        }

        if(check) System.out.println("YES");
        else System.out.println("NO");

    }
    public static void dfs(int start){
        if(visit[start]) return;
        visit[start] = true;
        for(int i = 1; i <= n; i++){
            if(map[start][i] == 1){
                dfs(i);
            }

        }
    }
}