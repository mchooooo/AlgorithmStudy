package study_210306;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 숨바꼭질
* dp[n] = Math.min(dp[n-1]+1, Math.min(dp[n+1]+1,dp[n/2]+1));
* dp 아님 ㅋㅋ
* 큐 이용한 너비우선탐색 ㄱㄱ
* */
class Pair{
    int pos;
    int depth;
    public Pair(int pos, int depth){
        this.pos = pos;
        this.depth = depth;
    }
}
public class BOJ_1697 {
    static int n;
    static int k;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n,0));
        visited[n] = true;
        int answer = bfs(q);
        System.out.println(answer);
//        if(n!=0) {
//            for(int i = n-1; i >= 0; i--){
//                dp[i] = dp[i+1]+1;
////                System.out.println(dp[i] = dp[i+1]+1);
//            }
//            dp[n+1] = 1;
//            dp[n*2] = 1;
//        }
//        int pos = n+2;
//        for(int i = 0; i < k+1; i++){
//            System.out.print(dp[i]+" ");
//        }
//        System.out.println();
//        while(dp[k] == 0){
//            if(pos%2 == 0) {
//                if(dp[pos+1] == 0){
//                    dp[pos] = Math.min(dp[pos-1]+1, dp[pos/2]+1);
//                }else{
//                    dp[pos] = Math.min(dp[pos-1]+1, Math.min(dp[pos/2]+1,dp[pos+1]+1));
//                }
//            }else{
//                if(dp[pos+1]!=0) {
//                    dp[pos] = Math.min(dp[pos - 1] + 1, dp[pos + 1] + 1);
//                }else{
//                    dp[pos] = dp[pos-1]+1;
//                }
//            }
//            pos++;
//        }
//        for(int i = 0; i < k+1; i++){
//            System.out.print(dp[i]+" ");
//        }
//        System.out.println();
//        System.out.println(dp[k]);

    }
    private static boolean valid(int n) {
        if (n < 0 || n > 100000 || visited[n])
            return false;
        return true;
    }
    private static int bfs(Queue<Pair> q){
        int result = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.pos == k){
                result = p.depth;
                break;
            }
            if(valid(p.pos-1)){
                q.add(new Pair(p.pos-1,p.depth+1));
                visited[p.pos-1] = true;
            }
            if(valid(p.pos+1)){
                q.add(new Pair(p.pos+1,p.depth+1));
                visited[p.pos+1] = true;
            }
            if(valid(p.pos*2)){
                q.add(new Pair(p.pos*2,p.depth+1));
                visited[p.pos*2] = true;
            }
        }
        return result;
    }
}
