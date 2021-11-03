package study_210611;

import java.util.Scanner;

public class BOJ_1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target =sc.nextLine();


        String temp = "";
        if(str.length()<target.length()){
            System.out.println(0);
            System.exit(0);
        }
        int cnt = 0;
        for(int i = 0; i < str.length()-target.length()+1; i++){
            boolean check = true;
            for(int j = 0; j < target.length(); j++){
                if(str.charAt(i+j) != target.charAt(j)){
                    check = false;
                    break;
                }
            }
            if(check){
                cnt++;
                i += target.length()-1;
            }
        }
        System.out.println(cnt);
    }
}
