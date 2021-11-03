package study_210607;

import java.util.Stack;

/*
* 짝지어 제거하기
* 스택활용?
* */
public class Programmers_12973 {
    public static void main(String[] args) {
        String s = "baabaa";
        int answer = 0;

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(st.isEmpty()) st.push(ch);
            else{
                if(st.peek() == ch){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }

        answer = st.size() == 0 ? 1 : 0;
        System.out.println(answer);

    }
}
