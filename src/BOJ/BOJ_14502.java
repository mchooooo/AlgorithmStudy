package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
*   삼성SW기출
*   연구소
*   백트래킹으로 벽3개 세우고
*   BFS로 퍼뜨리기
*
* */
public class BOJ_14502 {

    static class Virus{
        int x;
        int y;
        public Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int[][] arr;
    static int result;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] sp = br.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);
        arr = new int[n][m];
        result = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //백트래킹으로 벽 위치 설정
        makeWall(0,0,0);
        System.out.println(result);
    }
    public static void makeWall(int x, int y, int cnt){
        if(cnt == 3){
            int safeSpace = spreadVirus();
            result = Math.max(result, safeSpace);
            return;
        }

        for(int i = x; i < n; i++){
            int tempY = 0;
            if(i == x){
                tempY = y;
            }else{
                tempY = 0;
            }

            for(int j = tempY; j < m; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    makeWall(i,j,cnt+1);
                    arr[i][j] = 0;
                }
            }
        }

    }

    public static int spreadVirus(){
        Queue<Virus> q = new LinkedList<>();
        int[][] copyArr = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copyArr[i][j] = arr[i][j];
                if(arr[i][j] == 2) {
                    q.add(new Virus(i,j));
                    copyArr[i][j] = 1;
                }
                if(arr[i][j] == 1){
                    copyArr[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            Virus v = q.poll();
            int x = v.x;
            int y = v.y;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //범위 밖이면 패쓰
                if(!isValid(nx, ny)) continue;
                //벽이면 패쓰
                if(copyArr[nx][ny] == -1) continue;
                //이미 방문한 곳이면 패쓰
                if(copyArr[nx][ny] != 0) continue;

                copyArr[nx][ny] = copyArr[x][y] + 1;
                q.add(new Virus(nx,ny));

            }

        }


        return calSafeSpace(copyArr);
    }

    public static int calSafeSpace(int[][] arr){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= m) return false;
        return true;
    }

    public static void print(int[][] arr){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
