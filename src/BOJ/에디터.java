package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Collectors;

/*
https://www.acmicpc.net/problem/1406
 */
public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] sp = new String[N];

        for (int i = 0; i < N; i++) {
            sp[i] = br.readLine();
        }

        Stack<Character> st = new Stack<>(); // Input 저장
        Stack<Character> tempSt = new Stack<>(); // 커서의 움직임에 따라 값을 저장하는 임시 스택

        for (int i = 0; i < input.length(); i++) {
            st.push(input.charAt(i));
        }

        for (String cmd : sp) {
            switch (cmd.charAt(0)) {
                case 'L':
                    if (st.size() > 0) {
                        tempSt.push(st.pop());
                    }
                    break;
                case 'D':
                    if (tempSt.size() > 0) {
                        st.push(tempSt.pop());
                    }
                    break;
                case 'P':
                    char ch = cmd.split(" ")[1].charAt(0);
                    st.push(ch);
                    break;
                case 'B':
                    if (st.size() > 0) {
                        st.pop();
                    }
                    break;
            }
        }

        while (!tempSt.isEmpty()) {
            st.push(tempSt.pop());
        }

        String answer = st.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(answer);


    }
}
