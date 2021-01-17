package study_210117;

import java.util.Scanner;

public class Baekjoon_1389 {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N+1][N+1];
        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b]=1;
            arr[b][a]=1;
        }
        //연결 안된 선분에 큰 값을 미리 설정
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == 0 && i!=0 && j!=0 && i!=j){
                    arr[i][j] = 100;
                }
            }
        }
        //플로이드-워샬 알고리즘
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr.length;j++){
                for (int k = 1; k < arr.length; k++) {
                    if(k!=i && j!=k && i!=j){
                        arr[j][k] = Math.min(arr[j][i]+arr[i][k],arr[j][k]);
                    }
                }
            }
        }
// dfs로 풀려고 했었음
//        for(int i = 1; i < arr.length; i++){
//            int findFriend = -1;
//            for(int j = 1; j < arr.length;j++ ){
//                if(arr[i][j]==0 && i!=j){
//                    find(i,j,j, 1);
//                    findFriend = -1;
//                }
//            }
//        }

        int min=Integer.MAX_VALUE;
        int sum=0;
        int answer = 0;
        for(int i= 1; i < arr.length; i++){

            for(int j = 1; j < arr.length; j++){
                sum += arr[i][j];
            }
            if(sum < min){
                min = sum;
                answer=i;
            }
            sum=0;
        }
        System.out.println(answer);

    }

//    public static void find(int x, int y, int findFriend, int cnt){
//        boolean flag = false;
//        //1 2 2 1
//        for(int i = 1; i < arr.length; i++){
//            if(arr[x][i] == 1){
//                for(int j = 1; j < arr.length; j++){
//                    if(arr[i][j]==1 && j==findFriend){
//                        arr[x][findFriend] = cnt+1;
//                        flag=true;
//                        return;
//                    }
//
//                }
//            }
//        }

//    }

}
