package study_201028;

import java.util.Scanner;

public class Num_10026 {

    private static boolean[][] visit;
    private static char[][] arr;
    private static char[][] cpy;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];
        cpy = new char[n][n];
        visit = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String inp = sc.next();
            for(int j = 0; j < n; j++){
                arr[i][j] = inp.charAt(j);
                cpy[i][j] = inp.charAt(j);
                if(inp.charAt(j)=='G'){
                    cpy[i][j] = 'R';
                }
            }
        }
        int result1 =0;
        int result2 = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j]) {
                    dfs(i, j);
                    result1++;
                }
            }
        }
        arr = cpy;
        visit = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(!visit[i][j]) {
                    dfs(i, j);
                    result2++;
                }
            }
        }
        System.out.println(result1+" "+result2);



    }

    private static void dfs(int x, int y){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        char c = arr[x][y];
        if(!visit[x][y]){
            visit[x][y]=true;
            for(int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0&&ny>=0&&nx<=arr.length-1&&ny<=arr.length-1){
                    if(c == arr[nx][ny]){
                        dfs(nx,ny);
                    }
                }
            }

        }
    }



}
