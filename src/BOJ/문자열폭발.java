package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Collectors;

/*
https://acmicpc.net/problem/9935
 */
public class 문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String boom = br.readLine();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            st.push(ch);

            if (ch == boom.charAt(boom.length() - 1)) { // 폭탄의 마지막 값과 현재 값이 같다면 폭탄이 들었는지 확인
                if (st.size() >= boom.length()) { // 현재 스택에 들어있는 값이 폭탄보다 길어야 폭탄이 들었다고 볼 수 있음

                    String t = st.subList(st.size() - boom.length(), st.size())
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());

                    if (t.equals(boom)) {
                        for (int j = 0; j < boom.length(); j++) {
                            st.pop();
                        }
                    }

                }
            }

        }

        String answer = st.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(answer.length() == 0 ? "FRULA" : answer);

    }
}
