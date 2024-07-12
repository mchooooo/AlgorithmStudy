package Programmers;

import java.util.*;
public class 추억점수 {
    public static void main(String[] args) {
        String[][] name = {
            {"may", "kein", "kain", "radi"},
            {"kali", "mari", "don"},
            {"may", "kein", "kain", "radi"}
        };
        int[][] y = {
            {5, 10, 1, 3},
            {11, 1, 55},
            {5, 10, 1, 3}
        };
        String[][][] p = {
            {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}},
            {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}},
            {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}}
        };

        for (int i = 0; i < name.length; i++) {
            int[] answer = solution(name[i], y[i], p[i]);
            for (int j : answer) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[photo.length];
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (map.containsKey(photo[i][j])) {
                    sum += map.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}
