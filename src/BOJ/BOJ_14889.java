package BOJ;

import java.util.Scanner;

public class BOJ_14889 {
    static int[][] arr;
    static boolean[] chk;
    static int n;
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        chk = new boolean[n];
        min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0,0);
        System.out.println(min);

    }
    public static void dfs(int idx, int depth){
        if(depth == n / 2 ){
            //팀 조합 완성ㅋㅋ
            //start 팀, link 팀 계산
            int start = 0;
            int link = 0;

            for(int i = 0; i < n-1; i++){
                for(int j =i+1; j < n; j++){
                    if(chk[i] && chk[j]){
                        start += arr[i][j];
                        start += arr[j][i];
                    }else if(!chk[i] && !chk[j]){
                        link += arr[i][j];
                        link += arr[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(start-link));

        }

        for(int i = idx; i < n; i++){
            if(!chk[i]){
                chk[i] = true;
                dfs(i+1, depth+1);
                chk[i] = false;
            }
        }

    }
}
