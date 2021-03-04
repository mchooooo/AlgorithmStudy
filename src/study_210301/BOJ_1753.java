package study_210301;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
* 최단거리 구하기
* 1. 여기서는 플로이드 워샬 사용
* for i in len
*   for j in len
*      for k in len{
*         arr[i][j] = ?? 까먹음 ㅋㅋ
* }
* 메모리초과..
* */
public class BOJ_1753 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int startPos = sc.nextInt();

        int max = 10000001;
        int[][] arr = new int[V+1][V+1];
        //입력 받기
        for(int i = 0; i < E; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            arr[x][y] =w;
        }
        //경로가 없는 곳 충분히 큰 값으로 설정
        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                if(i!=j && arr[i][j] == 0){
                    arr[i][j] = max;
                }
            }
        }

//        for(int i = 1; i <= V; i++){
//            for(int j = 1; j <= V; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                for(int j = 1; j <= V; j++){
                    if(i != k && j!= k && j!= i) {
                        arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                    }
                }
            }
        }

//        for(int i = 1; i <= V; i++){
//            for(int j = 1; j <= V; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        for(int i = 1; i <= V; i++){
            System.out.println(arr[startPos][i] == max ? "INF" : arr[startPos][i]);
        }
    }

}
