package BOJ;
import java.util.*;

public class BOJ_21608 {

    static int[][] arr;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        map = new int[n*n+1][4];

        for(int i = 0; i < n*n; i++){

            int num = sc.nextInt();
            for(int j = 0; j < 4; j++){
                map[num][j] = sc.nextInt();
            }
            if(i == 0){ //첫번째 친구는 중앙
                arr[n/2][n/2] = num;
                continue;
            }
            int posX = 0;
            int posY = 0;
            int likeCnt = -1;
            int emptyCnt = -1;

            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++) {
                    if (arr[j][k] == 0){
                        int tempLike = 0;
                        int tempEmpty = 0;
                        for (int w = 0; w < 4; w++) {
                            int nx = j + dx[w];
                            int ny = k + dy[w];
                            if (isValid(nx, ny)) {
                                for (int z = 0; z < 4; z++) {
                                    if (arr[nx][ny] == map[num][z]) tempLike++;
                                }
                                if(arr[nx][ny] == 0) tempEmpty++;
                            }
                        }
                        if(likeCnt < tempLike){ // 현재 위치 저장
                            likeCnt = tempLike;
                            emptyCnt = tempEmpty;
                            posX = j;
                            posY = k;

                        }else if(likeCnt == tempLike){ // 같다면 빈자리가 많은 곳
                            if(emptyCnt < tempEmpty){
                                emptyCnt = tempEmpty;
                                posX = j;
                                posY = k;
                            }else if(emptyCnt == tempEmpty){
                                if(posX > j){//위쪽으로 간다.
                                    posX = j;
                                    posY = k;
                                }else if(posX == j){
                                    if(posY > k){ // x값이 같다면 y값이 작은 곳으로
                                        posY = k;
                                    }
                                }
                            }
                        }

                    }
                }
            }
            arr[posX][posY] = num;

        }
        int answer = 0;
        int[] score = {0,1,10,100,1000};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int student = arr[i][j];
                int cnt = 0;
                for(int k = 0; k < 4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(isValid(nx,ny)){
                        for(int w = 0; w < 4; w++){
                            if(map[student][w] == arr[nx][ny]){
                                cnt++;
                            }
                        }
                    }
                }
                answer += score[cnt];
            }
        }
//        print(arr);
        System.out.println(answer);

    }
    static void print(int[][] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= arr.length || y >= arr.length) return false;
        return true;
    }
}
