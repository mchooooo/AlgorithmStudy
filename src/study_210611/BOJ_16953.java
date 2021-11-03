package study_210611;

import java.util.Scanner;

public class BOJ_16953 {
    static long a;
    static long b;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
        bfs(a,1);
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
    public static void bfs(long n, int cnt){
        if(n > b) return;
        if(n == b){
            answer = Math.min(answer,cnt);
        }
        bfs(n*2, cnt+1);
        bfs((n*10)+1,cnt+1);
    }
}
