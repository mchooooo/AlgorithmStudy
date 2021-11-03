package study_210614;

import java.util.Scanner;

public class BOJ_1717_UnionFind {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        for(int i = 0; i <= n ; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == 0){
                union(b,c);
            }else{
                if(isCycle(b,c)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if( x != y ){
            parent[y] = x;
        }
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static boolean isCycle(int x, int y){
        if(find(x) == find(y)) return true;
        return false;
    }
}
