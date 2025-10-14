package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/10799
 */
public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                // 레이저인 경우
                if (input.charAt(i - 1) == '(') {
                    st.pop();
                    answer += st.size(); // 쇠막대 개수 더하기
                } else {
                    // 막대 끝인 경우
                    st.pop(); // 쇠막대 끝난 지점 -> ( 하나 빼줌
                    answer += 1;
                }


            }

        }

        System.out.println(answer);

    }
}
