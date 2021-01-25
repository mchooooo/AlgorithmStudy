package study_210123;

import java.util.Scanner;

//연결요소 개수
public class Baekjoon_11724 {

    public static int[][] arr;
    public static boolean[] visited;
    public static int cnt = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int point = sc.nextInt();
        int edge = sc.nextInt();

        arr = new int[point+1][point+1];
        visited = new boolean[point+1];

        for(int i = 1; i <= edge; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

//        visited[1] = true;


        for(int j = 1; j <= point; j++){
            if(!visited[j]){
                dfs(j);
                cnt++;
            }
        }


        for(int i = 1; i <arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


        System.out.println(cnt);

    }
    public static void dfs(int y){
        if(visited[y]) return;
        visited[y] = true;

        for(int i = 1; i < arr.length; i++){
            if(arr[y][i] == 1 && !visited[i]){
                dfs(i);
            }
        }


    }

}
