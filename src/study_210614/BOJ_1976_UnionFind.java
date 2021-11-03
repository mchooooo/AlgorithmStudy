package study_210614;

import java.util.Scanner;

public class BOJ_1976_UnionFind {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        //연결
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int a = sc.nextInt();
                if(a == 1){
                    union(i,j);
                }
            }
        }
        //확인
        int start = sc.nextInt();
        for(int i = 0; i < m-1; i++){
            if(!isCycle(start, sc.nextInt())){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

//        for(int i = 1; i <= n; i++){
//            System.out.println(i + " / " + parent[i]);
//        }

    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if( x != y ){
            parent[y] = x;
        }
    }
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }
    public static boolean isCycle(int x, int y){
        if(find(x) == find(y)) return true;
        return false;
    }
}
