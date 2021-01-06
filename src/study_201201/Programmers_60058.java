package study_201201;

import java.util.Stack;

//프로그래머스 레벨2 괄호 변환
public class Programmers_60058 {
    public static void main(String[] args){

        String p = "()))((()";
        String answer = "";
        answer = oneStep(p);
//        System.out.println("answer = "+answer);

    }

    public static String oneStep(String p){
        if(p.length()==0) return "";
        else return twoStep(p);
    }

    public static String twoStep(String p){
        int a = isBalance(p);
        String u = p.substring(0,a);
        String v = p.substring(a,p.length());
//        System.out.println("u = "+ u);
//        System.out.println("v = " + v);
        int b = isRight(u);
        if(b == 1) {
            String str = oneStep(v);
            u += str;
            return u;
        }else{
//            System.out.println("@@@@@@");
            String temp = "(";
            temp += oneStep(v);
            temp += ")";
            String reverseU = "";
            for(int i = 1; i < u.length()-1;i++){
                if(u.charAt(i)=='(') reverseU += ')';
                else reverseU += '(';
            }
            temp += reverseU;
//            System.out.println(temp);

            return  temp;
        }
    }

    public static int isBalance(String p){
        int cntLeft = 0;
        int cntRight = 0;
        for(int i =0; i < p.length(); i++){
            if(p.charAt(i)=='(') cntLeft++;
            else cntRight++;
            if(cntLeft == cntRight) return cntLeft+cntRight;
        }
        return -1;
    }

    public static int isRight(String p){

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i)=='(') st.push(p.charAt(i));
            else if(!st.isEmpty() && p.charAt(i)==')') st.pop();
        }
        if(st.size()==0) return 1;
        else return -1;

    }
}
