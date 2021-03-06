package study_210305;

import java.util.Scanner;

/*
* 1. 현재 위치를 청소한다.
* 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
*   2-a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
*   2-b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
*   2-c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
*   2-d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
* 조건대로 구현하면 될 듯
* */
class Robot{
    int x;
    int y;
    int pos;
    int cnt;
    public Robot(int x, int y, int pos){
        this.x = x;
        this.y = y;
        this.pos = pos;
    }
}
public class BOJ_14503 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Robot robot = new Robot(sc.nextInt(),sc.nextInt(),sc.nextInt());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        boolean flag =true;
        while(flag){
            if(arr[robot.x][robot.y]==0){
                robot.cnt += 1;
                arr[robot.x][robot.y] = 2;
                System.out.println("x = "+robot.x+" / y = "+robot.y);
            }
            while(true){
                if((arr[robot.x-1][robot.y]==1 || arr[robot.x-1][robot.y]==2) && (arr[robot.x+1][robot.y]==1 || arr[robot.x+1][robot.y]==2) && (arr[robot.x][robot.y-1]==1 || arr[robot.x][robot.y-1]==2) && (arr[robot.x][robot.y+1]==1 || arr[robot.x][robot.y+1]==2)){
                    if(robot.pos==0 && arr[robot.x+1][robot.y]==1){
                        flag=false;
                        break;
                    }
                    if(robot.pos==1 && arr[robot.x][robot.y-1]==1){
                        flag=false;
                        break;
                    }
                    if(robot.pos==2 && arr[robot.x-1][robot.y]==1){
                        flag=false;
                        break;
                    }
                    if(robot.pos==3 && arr[robot.x][robot.y+1]==1){
                        flag=false;
                        break;
                    }
                    if(robot.pos==0 && (arr[robot.x+1][robot.y]==0 || arr[robot.x+1][robot.y]==2)){
                        robot.x += 1;
                        continue;
                    }
                    if(robot.pos==1 && (arr[robot.x][robot.y-1]==0 || arr[robot.x][robot.y-1]==2)){
                        robot.y -= 1;
                        continue;
                    }
                    if(robot.pos==2 && (arr[robot.x-1][robot.y]==0 || arr[robot.x-1][robot.y]==2)){
                        robot.x -= 1;
                        continue;
                    }
                    if(robot.pos==3 && (arr[robot.x][robot.y+1]==0 || arr[robot.x][robot.y+1]==2)){
                        robot.y += 1;
                        continue;
                    }

                }
                //로봇 방향 왼쪽으로 회전

                //2-a
                if(robot.pos==0 && arr[robot.x][robot.y-1]==0){
                    robot.pos = (robot.pos+3) % 4;
                    robot.y -=1;
                    break;
                }else if(robot.pos == 1 && arr[robot.x-1][robot.y] == 0){
                    robot.pos = (robot.pos+3) % 4;
                    robot.x -= 1;
                    break;
                } else if (robot.pos == 2 && arr[robot.x][robot.y+1] == 0) {
                    robot.pos = (robot.pos+3) % 4;
                    robot.y +=1;
                    break;
                }else if(robot.pos == 3 && arr[robot.x+1][robot.y]==0){
                    robot.pos = (robot.pos+3) % 4;
                    robot.x += 1;
                    break;
                }else{
                    robot.pos = (robot.pos+3) % 4;
                    continue;
                }

            }
        }
        System.out.println(robot.cnt);
        print(arr);

    }
    private static void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
