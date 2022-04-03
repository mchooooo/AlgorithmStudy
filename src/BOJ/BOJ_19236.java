package BOJ;

/*
*   청소년 상어
*   삼성SW기출
*   상어가 갈 수 있는 위치 백트래킹으로 찾기 --> DFS
*
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19236 {

    static class Fish implements Comparable<Fish>{
        int x;
        int y;
        int dir;
        int num;
        boolean alive = true;
        public Fish(){}
        public Fish(int x, int y, int dir, int num, boolean alive){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.num = num;
            this.alive = alive;
        }

        @Override
        public int compareTo(Fish o){
            return Integer.compare(this.num, o.num);
        }
    }

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int[][] arr;
    static Fish[] fishs;
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[4][4];
        fishs = new Fish[17];
        for(int i = 0; i < 4; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                Fish f = new Fish();
                f.num = Integer.parseInt(st.nextToken());
                f.dir = Integer.parseInt(st.nextToken())-1;
                f.x = i;
                f.y = j;
                fishs[f.num] = f;
                arr[i][j] = f.num;
            }
        }

        //초기 시작 0,0에 있는 먹이를 먹고 방향을 잡음
        Fish f = fishs[arr[0][0]];
        f.alive = false;
        //상어 위치 = -1
        arr[0][0] = -1;
        print(arr);
        dfs(0,0,f.dir, arr, fishs, f.num);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int dir, int[][] map, Fish[] fishMap, int sum){

        result = Math.max(result,sum);

        //백트래킹의 경우 원래값으로 다시 돌려야하기 때문에 복사된 값을 이용
        int[][] copyArr = new int[4][4];
        Fish[] copyFish = new Fish[17];
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j++){
                copyArr[i][j] = map[i][j];
            }
        }
        for(int i = 1; i < 17; i++){
            copyFish[i] = new Fish(fishMap[i].x,fishMap[i].y,fishMap[i].dir,fishMap[i].num, fishMap[i].alive);
        }

        //물고기 이동

        moveFish(copyFish, copyArr);

        //상어의 이동???
        for(int i = 1; i < 4; i++){//4*4 배열에서 3번 움직일 수 있다.
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;

            //경계밖이 아니고 물고기가 있는 칸이면 먹음
            if(!isValid(nx,ny) || copyArr[nx][ny] <= 0) continue;

            //임시 저장 물고기
            Fish temp = copyFish[copyArr[nx][ny]];
            //먹은 물고기 번호 더하기
            int eat = temp.num;
            //물고기 죽음
            copyFish[temp.num].alive = false;
            //먹힌 물고기 위치에 상어 놓기
            copyArr[nx][ny] = -1;
            //원래 있던 상어칸은 빈칸이 됨
            copyArr[x][y] = 0;

            dfs(nx,ny, temp.dir, copyArr,copyFish, sum+eat);

            copyFish[temp.num].alive = true;
            copyArr[nx][ny] = temp.num;
            copyArr[x][y] = -1;


        }


    }

    public static void moveFish(Fish[] fish, int[][] arr){
//        System.out.println("----------before--------");
        //모두 옮겨야 한다
        for(int i = 1; i < 17; i++){
            //물고기가 죽었으면 넘김
            if(!fish[i].alive) continue;
            //방향 체크
            int x = fish[i].x;
            int y = fish[i].y;
            for(int j = 0; j < 8; j++){
                int dir = (fish[i].dir + j) % 8;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                //범위 밖이거나 상어가 있으면 패쓰
                if(!isValid(nx,ny) || arr[nx][ny] == -1) continue;
                arr[fish[i].x][fish[i].y] = 0;

                if (arr[nx][ny] != 0) {
                    Fish temp = fish[arr[nx][ny]];
                    //물고기 위치 옮김
                    temp.x = fish[i].x;
                    temp.y = fish[i].y;
                    arr[fish[i].x][fish[i].y] = temp.num;

                }
                fish[i].x = nx;
                fish[i].y = ny;

                arr[nx][ny] = fish[i].num;
                fish[i].dir = dir;
                break;
            }

        }

    }

    public static boolean isValid(int x, int y){
        if(x<0 || y < 0 || x>=4 || y>=4) return false;
        return true;
    }
    public static void print(int[][] arr){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
