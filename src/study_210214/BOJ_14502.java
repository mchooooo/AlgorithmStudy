package study_210214;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
* 1. 벽을 세운다.(dfs, 세울수 있는 곳 부터)
* 2. 바이러스를 퍼뜨린다.(bfs를 사용)
* 3. 안전공간을 카운트한다.(Math.max를 사용해서 가장 큰 값이 저장될 수 있도록 한다.)
* */
public class BOJ_14502 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] inp;
    static int[][] map;
    static int N;
    static int M;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        inp = map = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                inp[i][j] = map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(inp[i][j]==0){
                    map[i][j] = 1;
                    makeWall(1);
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(answer);

    }
    public static void makeWall(int cnt){
        if(cnt == 3){
            spreadVirus();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    makeWall(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void spreadVirus(){
        int[][] virus = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                virus[i][j] = map[i][j];
            }
        }
        Queue<Virus> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(virus[i][j]==2){
                    q.add(new Virus(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            Virus v = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];
                if(nx>=0 && ny >= 0 && nx < N && ny < M){
                    if(virus[nx][ny]==0){
                        virus[nx][ny] = 2;
                        q.add(new Virus(nx,ny));
                    }
                }
            }
        }
        calAnswer(virus);
    }
    public static void calAnswer(int[][] virus){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(virus[i][j]==0){
                    cnt++;
                }
            }
        }
        answer = Math.max(cnt, answer);
//        System.out.println(answer);
    }
}
class Virus{
    int x;
    int y;
    public Virus(int x, int y){
        this.x = x;
        this.y = y;
    }
}
