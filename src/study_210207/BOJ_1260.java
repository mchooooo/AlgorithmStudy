package study_210207;

import java.util.*;
//bfs 수정필요
public class BOJ_1260 {
    public static List<Integer> dfsList = new ArrayList<>();
    public static List<Integer> bfsList = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        int [][] arr = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = arr[y][x] = 1;
        }
        visited[V] = true;
        dfsList.add(V);
        for(int i = 1; i <= N; i++){
            if(!visited[i]&&arr[V][i]==1){
                dfs(arr,visited,i);
            }
        }

        visited = new boolean[N+1];
        visited[V] = true;
        bfsList.add(V);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(!visited[i]&&arr[V][i]==1){
                q.add(i);
            }
        }
        bfs(arr,visited,q);

        for(int i = 0; i < dfsList.size(); i++){
            System.out.print(dfsList.get(i)+" ");
        }
        System.out.println();
        for(int i = 0; i < bfsList.size(); i++){
            System.out.print(bfsList.get(i)+" ");
        }
    }

    public static void dfs(int[][] arr, boolean[] visited, int n){
        if(visited[n]) return;
        visited[n] = true;
        dfsList.add(n);
        for(int i = 1; i < arr.length; i++){
            if(!visited[i] && arr[n][i]==1){
                dfs(arr,visited,i);
            }
        }
    }

    public static void bfs(int[][] arr, boolean[] visited, Queue<Integer> q){
        int n = q.poll();
        if(visited[n]) return;
        visited[n] = true;
        bfsList.add(n);
        for(int i = 1; i < arr.length; i++){
            if(!visited[i]&&arr[n][i]==1){
                bfs(arr,visited,q);
            }
        }
    }

}
