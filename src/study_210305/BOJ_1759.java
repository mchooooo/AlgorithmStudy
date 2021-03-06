package study_210305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
* 암호만들기
* 조합만들어서 모음 1개 이상, 자음 2개 이상 확인
* */
public class BOJ_1759 {
    static List<String> list = new ArrayList<>();
    static int L;
    static int C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] sp = str.split(" ");
        L = Integer.parseInt(sp[0]);
        C = Integer.parseInt(sp[1]);
        str = br.readLine();
        sp = str.split(" ");
        char[] arr = new char[C];
        for(int i = 0; i < sp.length; i++){
            arr[i] = sp[i].charAt(0);
        }
        Arrays.sort(arr);
//        for(int i = 0; i < arr.length; i++){
//            System.out.print(arr[i]+" ");
//        }
        comb(arr,0,L,"");

//        System.out.println();
        for(String s : list){
            System.out.println(s);
        }
    }

    private static void comb(char[] arr, int start,int r, String str){
//        if(r==0) return;
        if(str.length() == L){
//            System.out.println("@@");
            int mo = 0;
            int ja = 0;
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch=='u') mo++;
                else{
                    ja++;
                }
            }
            if(mo>=1 && ja >=2){
                list.add(str);
//                System.out.println(str);
            }
            return;
        }
        for(int i = start; i < arr.length; i++){
            str += arr[i]+"";
//            System.out.println("str = "+str);
            comb(arr,i+1,r-1,str);
            str = str.substring(0,str.length()-1);
        }
    }
}
