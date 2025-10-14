package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        dfs(new StringBuilder(t), s);
        System.out.println(answer);
    }

    private static void dfs(StringBuilder current, String target) {
        if (answer == 1) return; // 이미 찾았으면 중단

        if (current.length() == target.length()) {
            if (current.toString().equals(target)) {
                answer = 1;
            }
            return;
        }

        // 1. 끝이 A이면 제거
        if (current.charAt(current.length() - 1) == 'A') {
            StringBuilder next = new StringBuilder(current);
            next.deleteCharAt(next.length() - 1);
            dfs(next, target);
        }

        // 2. 처음이 B이면 뒤집고 끝 제거
        if (current.charAt(0) == 'B') {
            StringBuilder next = new StringBuilder(current);
            next.reverse();
            next.deleteCharAt(next.length() - 1);
            dfs(next, target);
        }
    }
}