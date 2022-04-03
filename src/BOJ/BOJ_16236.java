package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
*   아기상어
*   삼성SW기출
*   최단거리 --> BFS
*   1. 입력받기
*   2. 먹을 것이 있나 찾기
*   3. 조건에 맞는 가장 가까운 먹이 먹기
*   4. 반복
* */
public class BOJ_16236 {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] arr;
    static int[][] chk;
    static int size = 2;
    static int sharkX;
    static int sharkY;
    static int eatCnt = 0;
    static int minX, minY, minDist, result = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        chk = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] sp = br.readLine().split(" ");
            for(int j = 0; j < sp.length; j++){
                arr[i][j] = Integer.parseInt(sp[j]);
                if(arr[i][j] == 9){
                    sharkX = i;
                    sharkY = j;
                    arr[i][j] = 0;
                }
            }
        }

        while(true){
            init();
            bfs(sharkX, sharkY);

            //먹을 수 있는 물고기가 있는 경우
            if(minX != 21 && minY != 21){
//                System.out.println("### = " + chk[minX][minY]);
                //시간 더하기
                result += chk[minX][minY];
                //먹은 물고기 수 하나 더하기
                eatCnt++;
                if(eatCnt == size){
                    size+=1;
                    eatCnt = 0;
                }
                //먹은 물고기 위치 0으로 초기화
                arr[minX][minY] = 0;
                //상어 위치 초기화
                sharkX = minX;
                sharkY = minY;

            }else{
                break;
            }


        }
        System.out.println(result);
//        print();
    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        chk[x][y] = 0;
        while(!q.isEmpty()){
            Node n = q.poll();
            x = n.x;
            y = n.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //배열 범위를 벗어남
                if(!isValid(nx,ny)) continue;
                //상어 크기보다 큰 물고기가 있거나 이미 방문한 곳이면 패스
                if(arr[nx][ny] > size || chk[nx][ny] != -1) continue;
                //거리 증가
                chk[nx][ny] = chk[x][y] + 1;

                //먹을 수 있는 물고기라면
                if(arr[nx][ny] < size && arr[nx][ny] != 0){
                    //이동거리 비교
                    if(minDist > chk[nx][ny]){
                        minX = nx;
                        minY = ny;
                        minDist = chk[nx][ny];
                    }else if(minDist == chk[nx][ny]){ //찾은 물고기들이 거리가 같다면
                        //가장 왼쪽인지 확인
                        if(minX == nx){
                            if(minY > ny){
                                minX = nx;
                                minY = ny;
                            }
                        }else if(minX > nx){
                            minX = nx;
                            minY = ny;
                        }
                    }

                }
                q.add(new Node(nx,ny));
            }

        }

    }

    public static boolean isValid(int x, int y){
        if(x < 0 || x >= arr.length || y < 0 || y>=arr[0].length) return false;
        return true;
    }

    //반복마다 초기화
    public static void init(){
        minX = 21;
        minY = 21;
        minDist = 401;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                chk[i][j] = -1;
            }
        }
    }
    public static void print(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
