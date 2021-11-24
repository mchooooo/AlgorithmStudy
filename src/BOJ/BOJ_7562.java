package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 나이트의 이동
* bfs?
* 백트래킹?
* */

public class BOJ_7562 {
    static class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[][] arr;
    static boolean[][] chk;
    static int x;
    static int y;
    static int destX;
    static int destY;
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int l = sc.nextInt();
            arr = new int[l][l];
            chk = new boolean[l][l];
            x = sc.nextInt();
            y = sc.nextInt();
            destX = sc.nextInt();
            destY = sc.nextInt();
            answer = 0;
//            System.out.println(x + " / " + y + " / " + destX + " / " + destY);
            bfs();
            System.out.println(answer);
        }
    }
    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0));
        chk[x][y] = true;
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.x == destX && n.y == destY) {
                answer = n.cnt;
                return;
            }
            for(int i = 0; i < 8; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if(isValid(nx,ny) && !chk[nx][ny]){
                    chk[nx][ny] = true;
                    q.add(new Node(nx,ny,n.cnt+1));
                }
            }
        }
    }
    public static boolean isValid(int x, int y){
        if(x<0 || x>=arr.length || y<0 || y>=arr[0].length){
            return false;
        }
        return true;
    }
}
