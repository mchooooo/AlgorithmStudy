package study_210427;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_67259 {
    static int[][] board;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static Queue<Road> q;
    public static void main(String[] args) {
        board = new int[][]	{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        n = board.length;

        q = new LinkedList<>();
        q.add(new Road(0,0,0, -1));

        bfs();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(board[n-1][n-1]);

    }

    public static boolean isValid(int x, int y){
        if(x < 0 || x >= n || y <0 || y>=n) return false;
        return true;
    }

    public static void bfs(){

        while(!q.isEmpty()){
            Road r = q.poll();

            if(r.x == n-1 && r.y == n-1){
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nx = r.x + dx[i];
                int ny = r.y + dy[i];
                int nextField = 0;
                if(isValid(nx,ny) && board[nx][ny] != 1){ // nx, ny 가 범위안이고
                    //처음, 방향이 같으면 직진
                    if(r.dir == -1 || r.dir == i) nextField = r.cnt + 100;
                    else nextField = r.cnt + 600;

                    //처음방문하는 곳과 재방문인데 더 저렴하면 갱신
                    if(board[nx][ny] == 0){
                        board[nx][ny] = nextField;
                        q.add(new Road(nx, ny, nextField, i));
                    }else if( board[nx][ny] >= nextField){
                        board[nx][ny] = nextField;
                        q.add(new Road(nx,ny,nextField,i));
                    }


                }
            }


        }

    }

}

class Road{
    int x;
    int y;
    int cnt; //비용
    int dir;


    public Road(int x, int y, int cnt, int dir){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.dir = dir;
    }
}