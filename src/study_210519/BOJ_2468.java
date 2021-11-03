package study_210519;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2468 {
    static int n;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visit;
    static int maxRain = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for(int i =0; i < n; i++){
            String[] info = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(info[j]);
                maxRain = Math.max(maxRain, map[i][j]);

            }
        }
//        System.out.println(maxRain);
        int result = 1;
        int rain = 0;
        while (rain++ < maxRain) {
            visit = new boolean[n][n];
            int cnt = 0;
            flood(rain);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0 && !visit[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            result = Math.max(result,cnt);
        }


        System.out.println(result);

    }
    public static void print(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void flood(int rain){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] <= rain){
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void dfs(int x, int y){
        if(visit[x][y]) return;
        visit[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= 0 && nx < n && ny>= 0  && ny < n){
                if(map[nx][ny] != 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
