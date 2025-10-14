package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 단축키지정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            if (!set.contains(sb.charAt(0))) {
                set.add(Character.toLowerCase(sb.charAt(0)));
                set.add(Character.toUpperCase(sb.charAt(0)));
                sb.insert(0,'[');
                sb.insert(2, ']');
                System.out.println(sb);
                continue;
            }

            int idx = sb.indexOf(" ");

            if (idx != -1 && !set.contains(sb.charAt(idx + 1))) {
                set.add(Character.toLowerCase(sb.charAt(idx + 1)));
                set.add(Character.toUpperCase(sb.charAt(idx + 1)));
                sb.insert(idx + 1, '[');
                sb.insert(idx + 3, ']');
                System.out.println(sb);
                continue;
            }

            boolean flag = false;

            for (int j = 0; j < sb.length(); j++) {
                if (!set.contains(sb.charAt(j)) && sb.charAt(j) != ' ') {
                    flag = true;
                    set.add(Character.toUpperCase(sb.charAt(j)));
                    set.add(Character.toLowerCase(sb.charAt(j)));
                    sb.insert(j, '[');
                    sb.insert(j + 2, ']');
                    System.out.println(sb);
                    break;
                }

            }

            if (!flag) {
                System.out.println(sb);
            }

        }

    }
}
