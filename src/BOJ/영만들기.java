package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/7490
 */
public class 영만들기 {

    private static List<String> list;
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            dfs(2, 0, 1, "1");
            for (String result : list) {
                sb.append(result).append("\n");
            }

            if (T > 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int pos, long sum, long last, String expr) {
        if (pos > N) {
            if (sum + last == 0) {
                list.add(expr);
            }
            return;
        }

        // 1. 공백
        long concat = last >= 0 ? last * 10 + pos : last * 10 - pos;
        dfs(pos+1, sum, concat, expr + " " + pos);

        // 2) +
        dfs(pos + 1, sum + last, +pos, expr + "+" + pos);

        // 3) -
        dfs(pos + 1, sum + last, -pos, expr + "-" + pos);
    }
}
