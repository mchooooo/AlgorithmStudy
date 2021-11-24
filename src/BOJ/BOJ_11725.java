package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 트리의 부모 찾기
* 유니온파인드?
* --> dfs
* */
public class BOJ_11725 {

    /*
    *     0 0 0 1 0 1 0
    *     0 0 0 1 0 0 0
    *     0 0 0 0 1 1 0
    *     1 1 0 0 0 0 1
    *     0 0 1 0 0 0 0
    *     1 0 1 0 0 0 0
    *     0 0 0 1 0 0 0
    * */
    static List<Integer>[] list;
    static boolean[] chk;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        list = new List[n+1];
        chk = new boolean[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            list[y].add(x);
        }
        //chk[1] = true;
        dfs(1);
        for(int i = 2; i <= n; i++){
            System.out.println(parent[i]);
        }

    }
    public static void dfs(int start){

        chk[start] = true;
        for(int i = 0; i < list[start].size(); i++){
            int dest = list[start].get(i);
            if(!chk[dest]){
                parent[dest] = start;
                dfs(dest);
            }
        }
    }
}
