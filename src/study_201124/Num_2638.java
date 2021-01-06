package study_201124;

import java.util.Scanner;

public class Num_2638 {

    static int[][] arr;
    static int[][] outer;
    static boolean[][] visit;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int cnt;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = sc.nextInt();
            }
        }
//        배열출력
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        int answer = 0;
        while(true){
            int sum = 0;
            outer = new int[N][M];
            visit = new boolean[N][M];

            dfs(0,0); //아웃터씨발럼만들기

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(arr[i][j]==1){
                        int q = 0;
                        for(int k = 0 ; k<4; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if(nx>=0 && ny>=0 &&nx<arr.length &&ny<arr[0].length){
                                if(outer[nx][ny]==1){
                                    q++;
                                }

                            }
                        }
                        if(q>=2) {
                            arr[i][j]=0;
                        }
                    }
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j<M; j++){
                    sum += arr[i][j];
                }
            }

            answer ++;
            if(sum == 0 ) break;
        }
//
////                배열출력
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(outer[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y){
        if(!visit[x][y]){
            visit[x][y] = true;
            outer[x][y] =1;
            for(int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && ny>=0 &&nx<arr.length &&ny<arr[0].length){
                    if(arr[nx][ny]!=1){
                        dfs(nx,ny);
                    }
                }
            }
        }


    }
}
