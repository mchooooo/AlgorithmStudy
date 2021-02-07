package study_210207;

import java.util.Scanner;

public class BOJ_1475 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str= n+"";
        int[] arr = new int[10];

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            arr[Integer.parseInt(ch+"")] += 1;
        }

        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(i!=9 && i!=6){
                cnt = Math.max(cnt, arr[i]);
            }
        }
        cnt = Math.max((arr[6]+arr[9]+1)/2,cnt);
        System.out.println(cnt);


    }
}
