package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.acmicpc.net/problem/2607
 */
public class 비슷한단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String inp = br.readLine();
        String[] s = new String[n - 1];
        for (int i = 0; i < n - 1; i++) {
            s[i] = br.readLine();
        }

        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            answer += check(inp, s[i]);
//            System.out.println(inp + " / " + s[i]);
        }

        System.out.println(answer);

    }

    private static int check(String source, String target) {
        // 길이가 2이상 차이나면 비슷한단어가 아님
        if (Math.abs(source.length() - target.length()) > 1) {
            return 0;
        }

        int[] arr = new int[100];
        for (int i = 0; i < source.length(); i++) {
            arr[source.charAt(i) - 'A']++;
        }

        int cnt = 0;
        for (int i = 0; i < target.length(); i++) {
            int idx = target.charAt(i) - 'A';
            if (arr[idx] > 0) {
                cnt++;
                arr[idx]--;
            }
        }

        // 확인
        if (source.length() == target.length() && source.length() == cnt) {
            return 1;
        }

        if (source.length() == target.length() && source.length() - 1 == cnt) {
            return 1;
        }

        if (source.length() + 1 == target.length() && source.length() == cnt) {
            return 1;
        }

        if (source.length() - 1 == target.length() && target.length() == cnt) {
            return 1;
        }


        return 0;
    }
}
