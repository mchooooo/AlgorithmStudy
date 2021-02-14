package study_210214;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576 {
    /*
    * 1. 입력을 기준으로 모두 익어있는 상황을 확인
    * 2. 1이 아니면 bfs를 통해 토마토가 익는 날짜를 계산
    * 3. 모든 토마토가 익을 수 없는 상황인지 확인
    */
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] tomato;

    static int N;
    static int M;
    static int answer = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        tomato = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                tomato[i][j] = sc.nextInt();
            }
        }
        //1 익은토마토 0 안익은토마토 -1 토마토가 없는 칸
        //1과 -1의 합이 배열의 칸수와 같으면 모두 익어있는 상황
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j]==1 || tomato[i][j]==-1){
                    cnt++;
                }
            }
        }
        //토마토 모두 익어있는 상황
        if(cnt == N*M){
            System.out.println(0);
        }else{//아니면 익히러 보냄
            bfs();
            calAnswer();
            System.out.println(--answer);
        }
    }
    public static void bfs(){
        Queue<Tomato> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j]==1){//익은 토마토를 큐에 넣음.
                    q.add(new Tomato(i,j));
                }
            }
        }

        while (!q.isEmpty()){
            Tomato t = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i]+t.x;
                int ny = dy[i]+t.y;
                if(nx>=0 && ny>=0 && nx<N &&ny<M){

                    if(tomato[nx][ny]==0){
                        q.add(new Tomato(nx,ny));
                        tomato[nx][ny]=tomato[t.x][t.y]+1;
                    }
                }
            }

        }

    }
    public static void print(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(tomato[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void calAnswer(){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j]==0){
                    answer = 0;
                    return;
                }
                if(tomato[i][j] > answer){
                    answer = tomato[i][j];
                }
            }
        }
    }
}
class Tomato{
    int x;
    int y;
    public Tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}