package study_210513;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BOJ_16236 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;
    static int[][] dist;
    static int sharkSize = 2;
    static Node fishInfo = new Node(0,0);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dist = new int[N][N];
        int sharkX = 0;
        int sharkY = 0;
        for(int i = 0; i < N; i++){
            String[] info = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(info[j]);
                if(arr[i][j] == 9){
                    sharkX = i;
                    sharkY = j;
                    arr[i][j] = 0;
                }
            }
        }
        int eatFish = 0;

        print();
    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));


    }

    public static void print(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
