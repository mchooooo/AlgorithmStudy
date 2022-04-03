package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
*   삼성SW기출
*   연구소3
*   연구소에 바이러스가 퍼지는 최소시간 --> BFS로 퍼뜨리자?
* */
public class BOJ_17142 {
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
    static int[][] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static List<Virus> virusList;
    static Queue<Virus> q;
    static int result;
    static int emptySpace;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        virusList = new ArrayList<>();
        q = new LinkedList<>();
        result = Integer.MAX_VALUE;
        emptySpace = 0;

        //input 입력 받기
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int inp = Integer.parseInt(st.nextToken());
                arr[i][j] = inp;
                if(inp == 2){
                    virusList.add(new Virus(i,j,0));
                }
                if(inp == 0) emptySpace++;

            }
        }

        //활성 바이러스 선택
        selectVirus(0, 0);
        if(emptySpace == 0) System.out.println(0);
        else System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void spreadVirus(int emptySpace){
        Queue<Virus> queue = new LinkedList<>();
        boolean[][] chk = new boolean[n][n];

        for (Virus v : q) {
            chk[v.x][v.y] = true;
            queue.add(v);
        }

        while(!queue.isEmpty()){

            Virus v = queue.poll();
            int x = v.x;
            int y = v.y;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!isValid(nx,ny)) continue;
                if(chk[nx][ny] || arr[nx][ny] == 1) continue;

                if(arr[nx][ny] == 0) emptySpace--;
                if(emptySpace == 0){
                    result = Math.min(result, v.cnt+1);
                    return;
                }

                chk[nx][ny] = true;
                queue.add(new Virus(nx,ny,v.cnt+1));



            }
        }


    }

    public static void selectVirus(int cnt, int idx){
        if(cnt == m){
            spreadVirus(emptySpace);
            return;
        }
        //중복이 없어야 하니까????????? idx받음 같이
        for(int i = idx; i < virusList.size(); i++){
            Virus v = virusList.get(i);
//            arr[v.x][v.y] = 0; // 바이러스 위치 -1로 바꿔줌
            q.add(v); //큐에 ㄴ바이러스 넣기
            selectVirus(cnt+1, i+1);
            q.remove(v);
//            arr[v.x][v.y] = 2;
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

}