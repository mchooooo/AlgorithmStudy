package study_210304;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
class Node implements Comparable<Node>{
    int x;
    int y;
    int cnt;
    public Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
    @Override
    public int compareTo(Node o){
        return Integer.compare(this.cnt,o.cnt);
    }
}
/*
* 미로찾기
* BFS사용
* 방문하면 다시 방문 못하게 체크
* 이동경로 +1
* */
public class BOJ_2178 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        arr = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            for(int j =0; j < str.length(); j++){
                String ch = str.charAt(j)+"";
                int temp = Integer.parseInt(ch);
                arr[i+1][j+1] = temp;
            }
        }
        q.add(new Node(1,1,1));
        visited[1][1]=true;
        bfs();
        System.out.println(arr[n][m]);
        print();

    }
    private static void bfs(){

        while (!q.isEmpty()){
            Node node = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;
                if(nx>0 && ny > 0 && nx <= n && ny <= m && !visited[nx][ny]){
                    if(arr[nx][ny] == 1){
                        System.out.println("nx = "+nx+" / ny = "+ny);
                        q.add(new Node(nx,ny,node.cnt+1));
                        visited[nx][ny] = true;
                        arr[nx][ny] = node.cnt+1;
                    }
                }
            }

        }

    }
    private static void print(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
