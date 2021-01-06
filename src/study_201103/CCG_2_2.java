package study_201103;

public class CCG_2_2 {
    static int[][] map;
    static int zero = 0;
    static int one = 0;
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        map = arr;
        dfs(arr.length, 0, 0);
        System.out.println(zero);
        System.out.println(one);

    }


    private static void dfs(int n, int x, int y) {
        if(n==1) {
            if(map[x][y]==1) {
                one+=1;
            }else {
                zero+=1;
            }
            return;
        }

        if(check(n,x,y)) {
            return;
        }
        dfs(n/2 , x, y);
        dfs(n/2 , x+(n/2), y);
        dfs(n/2 , x, y+(n/2));
        dfs(n/2 , x+(n/2), y+(n/2));

    }

    private static boolean check (int n, int x, int y) {
        int flag = map[x][y];

        for(int i = x; i<x+n; i++) {
            for(int j = y; j<y+n; j++) {
                if(map[i][j]!=flag) {
                    return false;
                }
            }
        }

        if(flag==1) {
            one+=1;
        }else {
            zero+=1;
        }
        return true;

    }

}
