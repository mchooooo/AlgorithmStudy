package study_210127;

import java.util.Locale;

public class Programmers_72410 {

    public static void main(String[] args){


        String new_id = "!!!!!!!!!!!....";
        String answer = "";
        //step 1
        new_id = new_id.toLowerCase();
        System.out.println("step 1 \n"+new_id);
        String temp = "";
        //step 2
        for(int i = 0; i < new_id.length(); i++){
            char ch = new_id.charAt(i);
            if((ch>='a' && ch <='z') || (ch>='0' && ch<='9') || (ch=='-') || (ch=='_') || (ch=='.')){
                temp += ch;
            }
        }
        System.out.println("step 2 \n"+temp);

        //step3
        int len = temp.length();
        char[] arr = temp.toCharArray();
        temp = "";
        for(int i = 0; i < len; i++){
            if( i!=len-1 && arr[i]==arr[i+1] && arr[i]=='.'){
                continue;
            }else {
                temp += arr[i];
            }
        }
        System.out.println("step 3 \n"+temp);

        //step4
        String str = "";
        for(int i = 0; i < temp.length(); i++){
            char ch = temp.charAt(i);
            if(ch=='.' &&(i==0 || i == temp.length()-1)){
                continue;
            }else{
                str += ch;
            }
        }
        temp = str;
        System.out.println("step 4 \n"+temp);

        //step5
        if(temp.isEmpty()){
            temp = "a";
        }
        System.out.println("step 5 \n"+temp);

        //step6
        if(temp.length() >= 16){
            String tmp = "";
            for(int i = 0; i < 15; i++){
                tmp += temp.charAt(i);
            }
            if(tmp.charAt(tmp.length()-1)=='.') tmp = tmp.substring(0,tmp.length()-1);
            temp = tmp;
        }
        System.out.println("step 6 \n"+ temp);

        //step 7
        if(temp.length()<3){
            char ch = temp.charAt(temp.length()-1);
            for(int i = temp.length(); i < 3; i++){
                temp+=ch;
            }
        }

        System.out.println("result \n"+temp);

    }

}
