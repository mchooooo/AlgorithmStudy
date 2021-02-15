package study_210215;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_1829 {

    /*
    * 1. bfs를 통해 개수와 영역을 확인
    * */
    static int[] dx={-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static boolean[][] visited;

    public static void main(String[] args){

        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int m = 6;
        int n = 4;

        visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        int[] answer = new int[2];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    visited[i][j] =true;
                    q.add(new Pair(i,j,picture[i][j]));
                    bfs(picture, answer, m,n, q);
                }
            }
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);

//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                System.out.print(picture[i][j]+" ");
//            }
//            System.out.println();
//        }

    }
    public static void bfs(int[][] picture, int[] answer, int m, int n, Queue<Pair> q){
        int answer1 = 1;
        while (!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(nx>=0 && ny >=0 && nx < m && ny < n && !visited[nx][ny]){
                    if(p.z == picture[nx][ny]) {
                        q.add(new Pair(nx, ny, p.z));
                        visited[nx][ny] = true;
                        answer1++;
                    }
                }
            }
        }
        answer[1] = Math.max(answer1,answer[1]);
        answer[0]++;
    }
}

class Pair{
    int x;
    int y;
    int z;
    public Pair(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
