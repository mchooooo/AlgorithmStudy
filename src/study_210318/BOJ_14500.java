package study_210318;

import java.util.Scanner;

/*
* 테트로도미노
* 1. 4개 블럭 형태를 모두 계산
* 2. DFS를 통해 'ㅏ'모양 빼고 모두 계산 후 'ㅏ'모양 따로 계산
* */
public class BOJ_14500 {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] sol;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int max = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n+6][m+6];
        sol = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int temp = sc.nextInt();
                arr[i+3][j+3] = temp;
                sol[i][j] = temp;
            }
        }

//        for(int i = 3; i < n+3; i++){
//            for(int j = 3; j < m+3; j++){
//                search(i,j);
//            }
//        }
//        print();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //방문 트루
                visited[i][j] = true;
                //dfs
                dfs(i,j,sol[i][j],1);
                // 방문 해제 -> 완전탐색을 위해서
                visited[i][j] = false;

                exceptionShape(i,j);

            }
        }
        System.out.println(max);
    }

    // 1번 풀이
    private static void search(int x, int y){
        int sum = 0;
        // 1-1. 'ㅡ'
        for(int i = y; i <y+4; i++){
            sum += arr[x][i];
        }
        max = Math.max(sum,max);
        // 1-2. 'l'
        sum = 0;
        for(int i = x; i < x+4; i++){
            sum += arr[i][y];
        }
        max = Math.max(sum,max);

        // 2. 'ㅁ'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x][y+1];
        sum += arr[x+1][y];
        sum += arr[x+1][y+1];
        max = Math.max(sum,max);

        // 3-1-1. 'ㄴ'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x+1][y];
        sum += arr[x+2][y];
        sum += arr[x+2][y+1];
        max = Math.max(sum,max);

        // 3-1-2. 1번 케이스 y축 대칭
        sum = 0;
        sum += arr[x][y];
        sum += arr[x+1][y];
        sum += arr[x+2][y];
        sum += arr[x+2][y-1];
        max = Math.max(sum,max);

        // 3-2-1. 'ㄱ'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x][y+1];
        sum += arr[x][y+2];
        sum += arr[x+1][y+2];
        max = Math.max(sum, max);

        // 3-2-2. 1번에 x축 대칭
        sum = 0;
        sum += arr[x][y];
        sum += arr[x][y+1];
        sum += arr[x][y+2];
        sum += arr[x-1][y+2];
        max = Math.max(sum, max);

        // 3-3-1. 'ㄴ-'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x+1][y];
        sum += arr[x+1][y+1];
        sum += arr[x+1][y+2];
        max = Math.max(sum,max);

        //3-3-2. 1번에 y축 대칭
        sum = 0;
        sum += arr[x][y];
        sum += arr[x][y+1];
        sum += arr[x+1][y+1];
        sum += arr[x+2][y+1];
        max = Math.max(max, sum);

        //3-4-1. 'ㄱ' 꺾이는 부분 시작 ㅋㅋ;
        sum = 0;
        sum += arr[x][y];
        sum += arr[x+1][y];
        sum += arr[x][y+1];
        sum += arr[x][y+2];
        max = Math.max(max,sum);

        //3-4-2. 1번 y축대칭
        sum = 0;
        sum += arr[x][y];
        sum += arr[x+1][y];
        sum += arr[x+2][y];
        sum += arr[x][y+1];
        max = Math.max(sum,max);

        //4-1-1 'ㄴ
        //        ㄱ'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x+1][y];
        sum += arr[x+1][y+1];
        sum += arr[x+2][y+1];
        max = Math.max(sum,max);

        //4-1-2 1번 y축 대칭
        sum = 0;
        sum += arr[x][y];
        sum += arr[x+1][y];
        sum += arr[x+1][y-1];
        sum += arr[x+2][y-1];
        max = Math.max(sum,max);

        //4-2-1 'ㄱ
        //        ㄴ'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x][y+1];
        sum += arr[x+1][y+1];
        sum += arr[x+1][y+2];
        max = Math.max(sum,max);

        //1번 x축 대칭
        sum = 0;
        sum += arr[x][y];
        sum += arr[x][y+1];
        sum += arr[x-1][y+1];
        sum += arr[x-1][y+2];
        max = Math.max(max,sum);

        //5-1 'ㅏ'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x+1][y];
        sum += arr[x+1][y+1];
        sum += arr[x+2][y];
        max = Math.max(sum,max);

        //5-2 'ㅓ'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x+1][y];
        sum += arr[x+1][y-1];
        sum += arr[x+2][y];
        max = Math.max(sum,max);

        //5-3 'ㅜ'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x][y+1];
        sum += arr[x+1][y+1];
        sum += arr[x][y+2];
        max = Math.max(sum,max);

        //5-4 'ㅗ'
        sum = 0;
        sum += arr[x][y];
        sum += arr[x][y+1];
        sum += arr[x-1][y+1];
        sum += arr[x][y+2];
        max = Math.max(sum,max);
    }


    private static void print(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void dfs(int x, int y, int sum ,int depth){
        if(depth == 4){
            max = Math.max(sum,max);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isValid(nx,ny) && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx,ny,sum+sol[nx][ny],depth+1);
                visited[nx][ny] = false;
            }
        }
    }

    private static void exceptionShape(int x, int y){
        int sum = sol[x][y];
        int wing = 4;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(wing < 3) return;
            if(!isValid(nx,ny)){
                wing--;
                continue;
            }
            min = Math.min(min,sol[nx][ny]);
            sum += sol[nx][ny];
        }
        sum -= min;
        max = Math.max(max,sum);
    }
    private static boolean isValid(int x, int y){
        if(x >= 0 && x < n && y>=0 && y < m) return true;
        return false;
    }

}
