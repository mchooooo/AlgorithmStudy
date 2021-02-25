package study_210223;

import java.util.Scanner;

public class BOJ_15650 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1];
        visited = new boolean[N+1];
        dfs(0,1);
    }
    public static void dfs(int cnt, int index){
        if(cnt == M){
            //멈추고 출력
            for(int i = 0; i < M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = index; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                dfs(cnt+1,i+1);
                visited[i] = false;
            }
        }
    }
}
