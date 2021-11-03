package study_210522;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BOJ_13023 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        map = new int[n][n];
        check = new boolean[n];
        for(int i = 0; i<m;i++){
            info = br.readLine().split(" ");
            int x = Integer.parseInt(info[0]);
            int y = Integer.parseInt(info[1]);
            map[x][y] = map[y][x] = 1;
        }

        for(int i = 0; i < n; i++){
            if(map[0][i] == 1){
                dfs(i);
            }
        }
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(!check[i]) {
                flag = true;
                break;
            }
        }
        for(boolean b : check){
            System.out.println(b);
        }

        if(flag) System.out.println(0);
        else System.out.println(1);


//        print();

    }
    public static void dfs(int x){
        if(check[x]) return;
        check[x] = true;
        for(int i = 0; i < n; i++){
            if(map[x][i] == 1 ) dfs(i);
        }
    }
    public static void print(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
