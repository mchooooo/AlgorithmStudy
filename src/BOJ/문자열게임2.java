package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String inp = br.readLine();
            int k = Integer.parseInt(br.readLine());

            List<Integer>[] alphabets = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                alphabets[i] = new ArrayList<>();
            }

            for (int i = 0; i < inp.length(); i++) {
                char c = inp.charAt(i);
                alphabets[c - 'a'].add(i);
            }

            int maxLen = Integer.MIN_VALUE;
            int minLen = Integer.MAX_VALUE;

            for (int i = 0; i < 26; i++) {
                List<Integer> list = alphabets[i];

                if (list.size() < k) {
                    continue;
                }

                // 윈도우 슬라이싱
                // [0, 1, 2]
                // [0, 1] 0 ~ 1
                // [1, 2] 1 ~ 2
                // 2 - 0, 2 - 1
                for (int j = 0; j <= list.size() - k; j++) {
                    maxLen = Math.max(maxLen, list.get(k + j - 1) - list.get(j) + 1);
                    minLen = Math.min(minLen, list.get(k + j - 1) - list.get(j) + 1);

                }


            }
            if (minLen == Integer.MAX_VALUE || maxLen == Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minLen + " " + maxLen);
            }

        }

    }
}
