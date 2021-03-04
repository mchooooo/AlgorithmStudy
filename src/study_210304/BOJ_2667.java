package study_210304;

import java.util.*;
import java.io.*;
/*
* 단지번호붙이기
* BFS or DFS 단지 개수 세려면 BFS가 날듯?
* 단지 개수, 단지내 집의 개수 출력
* Node는 같은 패키지에 있는 클래스 갖다씀ㅋㅋ
* */
public class BOJ_2667 {
    static int n;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> pq = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String inp = br.readLine();
            for(int j = 0; j < n; j++){
                int temp = inp.charAt(j) - '0';
                arr[i][j] = temp;
            }
        }
        int totalCnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    System.out.println("i = "+i+" / j = "+j);
                    q.add(new Node(i,j,1));
                    visited[i][j] =true;
                    bfs(1);
                    totalCnt++;
                }
            }
        }
        System.out.println(totalCnt);
        if(totalCnt == 0) System.out.println(0);
        Collections.sort(pq);
        for(int i : pq){
            System.out.println(i);
        }
//        print();
    }
    private static void bfs(int cnt){
        int max = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx>=0 && ny>=0 && nx < n && ny < n && !visited[nx][ny]){
                    if(arr[nx][ny]==1){
                        q.add(new Node(nx,ny,node.cnt+1));
                        visited[nx][ny] = true;
                        cnt++;
                        max = Math.max(max,cnt);
                        System.out.println("max= "+max);
                    }
                }
            }
        }
        pq.add(max);
    }
    private static void print(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

