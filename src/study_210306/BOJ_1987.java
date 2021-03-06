package study_210306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
* 한 번 지나온 알파벳은 다시 지날 수 없음!
* 'A'-'A' = 0
* 알파벳을 인트배열로 담아서 방문 확인!
* */
class Node{
    int x;
    int y;
    int z;
    public Node(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class BOJ_1987 {
    static int[] dx ={-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[] visited;
    static int[][] arr;
    static Queue<Node> q = new LinkedList<>();
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] sp = str.split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        visited = new boolean[26];
        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < m; j++){
                char ch = str.charAt(j);
                arr[i][j] = ch-'A';
            }
        }
//        q.add(new Node(0,0,arr[0][0]));
        visited[arr[0][0]] = true;
//        bfs();

        dfs(0,0,1);
//        print();
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int cnt){
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length){
                if(!visited[arr[nx][ny]]){
                    visited[arr[nx][ny]]=true;
                    dfs(nx,ny,cnt+1);
                    visited[arr[nx][ny]] = false; //false 로 바꿔주어야 완전 탐색 ㅋㅋ;;
                }
            }
        }
        answer = Math.max(cnt,answer);
    }
    private static void bfs(){
        int cnt = 1;
        while (!q.isEmpty()){
            Node node = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length && !visited[arr[nx][ny]]){
                    cnt++;
                    visited[arr[nx][ny]] = true;
                    q.add(new Node(nx,ny,arr[nx][ny]));
                }
            }
            answer = Math.max(answer,cnt);
        }
    }

    private static void print(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
