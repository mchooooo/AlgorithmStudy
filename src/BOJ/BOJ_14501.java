package BOJ;

import java.util.Scanner;

public class BOJ_14501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] t = new int[n+2];
        int[] p = new int[n+2];

        for(int i = 1; i <= n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        int max = 0;


        for(int i = n; i >= 1 ; i--){
            if(i + t[i] > n + 1) p[i] = p[i+1]; //날짜를 넘어가서 그냥 넘어옴ㅋㅋ
            else{
                p[i] = Math.max(p[i+1], p[i]+p[i+t[i]]); //당일 스케줄을 실행 --> p[i]+p[i+t[i]]; 실행x --> p[i+1];
                max = Math.max(p[i], max);
            }
        }
        System.out.println(max);

    }//main

}
