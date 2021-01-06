package study_201124;

import java.util.Scanner;

public class Num_15904 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 65 && ch <=90){
               if(ch=='U' && cnt==0) cnt++;
               if(ch=='C'&&cnt==1) cnt++;
               if(ch=='P'&&cnt==2) cnt++;
               if(ch=='C'&&cnt==3) {
                   cnt++;
                   break;
               }
            }


        }
        System.out.println(cnt);
        if (cnt==4) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");

//        System.out.println(temp);




    }
}
