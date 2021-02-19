package study_210217;

import java.util.Stack;

/*
* 올바른 괄호
* 1. '(' 스택에 push
* 2. ')' pop
* 3. 스택이 비었다면 true, 아니면 false
* */
public class Programmers_12909 {
    public static void main(String[] args){
        boolean answer = false;

        String s = ")()(";
        if(s.charAt(0)==')') answer=false;

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') st.push(c);
            else if(c==')'&& !st.isEmpty()) st.pop();
        }

        if(st.isEmpty()) answer = true;
        else answer = false;

        System.out.println(answer);

    }
}
