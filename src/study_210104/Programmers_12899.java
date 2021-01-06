package study_210104;

import java.util.Stack;

public class Programmers_12899 {

    //124나라
    public static void main(String[] args){
        int n = 6;
        String answer = "";
        int share = n;
        int remainder = -1;
        Stack<String> st = new Stack<>();
        while(share != 0){
            remainder = share % 3;
            share = share / 3;

            if(remainder == 0){
                st.push("4");
                share--;
            }else if(remainder == 1){
                st.push("1");
            }else if(remainder == 2){
                st.push("2");
            }
        }

        while (!st.isEmpty()){
            answer += st.pop();
        }

        System.out.println(answer);


    }

}
