package Programmers;

import java.util.*;

public class 광물캐기 {
    static class Node {
        int dia;
        int iron;
        int stone;
        int size;
        public Node (){}
        public Node (int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
    public static void main(String[] args) {
        int[][] p = {
            {1,3,2},
            {0,1,1}
        };
        String[][] m = {
            {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"},
            {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}
        };

        for (int i = 0; i < p.length; i++) {
            System.out.println(solution(p[i], m[i]));
        }
    }

    public static int solution (int[] picks, String[] minerals) {
        int answer = 0;
        List<Node> list = new ArrayList<>();
        int dia = 0;
        int iron = 0;
        int stone = 0;
        int sum = Arrays.stream(picks).sum();
        for (int i = 0; i < minerals.length; i++) {
            if (sum * 5 - 1 < i) {
                break;
            }
            switch (minerals[i]) {
                case "diamond":
                    dia += 1;
                    iron += 5;
                    stone += 25;
                    break;
                case "iron":
                    dia += 1;
                    iron += 1;
                    stone += 5;
                    break;
                case "stone":
                    dia += 1;
                    iron += 1;
                    stone += 1;
                    break;
            }

            if ((i + 1) % 5 == 0 || i == minerals.length - 1) {
                list.add(new Node(dia, iron, stone));
                dia = 0;
                iron = 0;
                stone = 0;
            }
        }

        list.sort(Comparator.comparingInt(o -> -o.stone));


        int idx = 0;
        for (int i = 0; i < sum; i++) {
            if (idx == list.size()) {
                break;
            }

            if (picks[0] > 0) {
                answer += list.get(idx++).dia;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += list.get(idx++).iron;
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += list.get(idx++).stone;
                picks[2]--;
            }
        }

        return answer;
    }
}
