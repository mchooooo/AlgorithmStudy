package study_210222;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_15649 {

    static int[] arr;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1];

        visited = new boolean[N+1];
        func(0);

    }
    public static void func(int cnt){
        if(cnt == M){
            for(int i = 0; i < M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                func(cnt+1);
                visited[i] = false;
            }
        }
    }
}
