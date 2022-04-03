package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
*   삼성SW기출
*   연구소2
*   바이러스 위치 백트래킹으로 정하고 BFS로 퍼뜨리기
*   ㅋㅋ아 어렵다
* */
public class BOJ_17141 {
    static class Virus{
        int x;
        int y;
        int cnt;
        public Virus(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int n;
    static int m;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static Virus[] virus;
    static List<Virus> virusList;
    static int result;
    static int emptySpace;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] sp = br.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);
        arr = new int[n][n];
        virus = new Virus[m];
        virusList = new ArrayList<>();
        result = Integer.MAX_VALUE;
        emptySpace = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int inp = Integer.parseInt(st.nextToken());
                arr[i][j] = inp;
                if(inp != 1) emptySpace++;
                if(inp == 2) virusList.add(new Virus(i,j,0));
            }
        }

        selectVirus(0,0);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);

    }

    public static void selectVirus(int idx, int cnt){

        if(cnt == m){
            spreadVirus();
            return;
        }

        for(int i = idx; i < virusList.size(); i++){
            virus[cnt] = virusList.get(i);
            selectVirus(i+1, cnt+1);
        }
    }

    public static void spreadVirus(){
        Queue<Virus> q = new LinkedList<>();
        int[][] copyArr = new int[n][n];
        boolean[][] chk = new boolean[n][n];

        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1) {
                    copyArr[i][j] = arr[i][j];
                }else{
                    copyArr[i][j] = 0;
                }
            }
        }

        for(Virus v : virus){
            copyArr[v.x][v.y] = 0;
            chk[v.x][v.y] = true;
            q.add(v);
        }

        while(!q.isEmpty()){
            Virus v = q.poll();
            int x = v.x;
            int y = v.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(!isValid(nx, ny)) continue;
                if(chk[nx][ny]) continue;
                if(arr[nx][ny] == 1) continue;


                copyArr[nx][ny] = v.cnt+1;
                chk[nx][ny] = true;
                max = copyArr[nx][ny];

                q.add(new Virus(nx,ny, v.cnt+1));


            }

        }

        boolean flag = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1) continue;
                if(!chk[i][j]) {
                    flag = false;
                }
            }
        }

        print(copyArr);

        if(flag) {

            result = Math.min(result, max);
        }



    }



    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= n) return false;
        return true;
    }

    public static void print(int[][] arr){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void print(boolean[][] arr){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
