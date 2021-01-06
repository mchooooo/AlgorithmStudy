package study_201229;

import java.util.Scanner;

public class Num_4796 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = 1;
        while(true){
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();
            if(L==0 && P ==0 && V == 0) break;

            int num = 0;

            while(V>P) {

                num+=L;

                V -= P;

            }
            if(V > L) {
                num += L;
            }else{
                num+=V;
            }
            System.out.println("Case "+c+": "+num);
            c++;
        }
    }

}
