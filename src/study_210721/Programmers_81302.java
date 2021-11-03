package study_210721;

import java.util.LinkedList;
import java.util.Queue;

/*
* 프로그래머스 거리두기 확인하기
* 응시자 한명 bfs로 확인 빈 책상 기준으로 최단 거리가 3이상이면 거리두기 완료 아니면 거리두기 x
* */
public class Programmers_81302 {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] answer = new int[places.length];

        for(int i = 0; i < 5; i++){
            char[][] arr = new char[5][5];
            for(int j = 0; j < places.length ; j++){
                arr[j] = places[i][j].toCharArray();
            }
            print(arr);
//            boolean flag = solution(arr);
//            System.out.println(flag);
            if(solution(arr)) answer[i] = 1;
            else answer[i] = 0;
        }

    }
    public static void print(char[][] arr){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean solution(char[][] arr){
        boolean flag = true;
        boolean[][] check = new boolean[5][5];
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == 'P'){
                    q.add(new Node(i,j,0));
                    System.out.println("start BFS = " + i + " / " +j);
                    check[i][j] = true;
                    flag = bfs(q,arr, check);
                    if(!flag) return flag;
                    check = new boolean[5][5];
                    q.clear();
//                    System.out.println("end BFS result = " + flag);
                }
            }
        }
        return flag;
    }

    public static boolean bfs(Queue<Node> q, char[][] arr, boolean[][] check){
//        System.out.println("In BFS Q size = " + q.size());
        while(!q.isEmpty()){
            Node n = q.poll();

//            System.out.println("in BFS n.x and n.y = " + n.x + " / " + n.y + " / "+n.cnt);
            if(n.cnt > 0 && arr[n.x][n.y]=='P'){
            System.out.println("in BFS n.x and n.y = " + n.x + " / " + n.y + " / "+n.cnt);
                if(n.cnt <= 2) return false;
                else return true;
            }
            for(int i =0; i < 4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if(isValid(nx,ny) && !check[nx][ny]){
                    if(arr[nx][ny] == 'O' || arr[nx][ny] == 'P'){
                        check[n.x][n.y] = true;
                        q.add(new Node(nx,ny,n.cnt+1));
                    }
                }
            }
        }

        return true;
    }
    public static boolean isValid(int x, int y){
        if(x < 0 || x > 4 || y < 0 || y > 4) return false;
        return true;
    }
}

class Node{
    int x;
    int y;
    int cnt = 0;
    public Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}