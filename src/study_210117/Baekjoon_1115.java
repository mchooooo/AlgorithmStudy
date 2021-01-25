package study_210117;

import java.util.Scanner;

public class Baekjoon_1115 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];

        for(int i = 0; i < P.length; i++){
            P[i] = sc.nextInt();
        }
        int[] Q = new int[N];

        for(int i = 1; i < Q.length; i++){
            Q[i] = P[Q[i-1]];
        }

        for(int i = 0; i < Q.length; i++){
            System.out.print(Q[i]+" ");
        }

//        for(int i = 0; i < Q.length;i++) {
//            for(int j = 0; j < Q.length; j++){
//                if(P[i]==Q[j]){
//                    Q[j] = -1;
//                    break;
//                }
//            }
//        }
//        int cnt =0;
//        for(int i = 0; i < Q.length; i++){
//            if(Q[i] != -1){
//                cnt++;
//            }
//        }

//        System.out.println(cnt);

    }

}
