package study_210207;

import java.util.Scanner;

public class BOJ_1065 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(hansu(n));
    }
    public static int hansu(int n ){
        if(n < 100) return n;
        int cnt = 99;
        for(int i = 100; i <= n; i++){
            int h = i/100;
            int t = i/10%10;
            int o = i%10;
            if((o-t)==(t-h)) cnt++;
        }
        return cnt;
    }
}
