package study_210421;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class BOJ_11403 {

    static int[][] map;
    static boolean[] check;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] sp = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(sp[j]);
            }
        }

        for(int i = 0; i < N; i++){
            check=new boolean[N];
            for(int j = 0; j < N; j++){
                if(map[i][j]==1){
                    dfs(i,j);
                }
            }
            for(int j = 0; j < N; j++){
                if(check[j]){
                    map[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void dfs(int x, int y){
        if(check[y]) return;
        check[y] = true;
        for(int i = 0; i < N; i++){
            if(map[y][i] == 1){
                dfs(y,i);
            }
        }
    }
}
