package Programmers;

public class 바탕화면정리 {
    public static void main(String[] args) {
        String[][] w = {
            {".#...", "..#..", "...#."},
            {"..........", ".....#....", "......##..", "...##.....", "....#....."},
            {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."},
            {"..", "#."}
        };

        for (int i = 0; i < w.length; i++) {
            int[] answer = solution(w[i]);
            for (int n : answer) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];


        int n = wallpaper.length; // 3
        int m = wallpaper[0].length(); // 5
        boolean find = false;

        // 가장 왼쪽 점 찾기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wallpaper[j].charAt(i) == '#') {
                    answer[1] = i;
                    find = true;
                    break;
                }
            }

            if (find) {
                break;
            }
        }

        // 가장 위 점 찾기
        find = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    answer[0] = i;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }

        // 가장 오른쪽 점 찾기
        find = false;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (wallpaper[j].charAt(i) == '#') {
                    answer[3] = i + 1;
                    find = true;
                    break;
                }
            }

            if (find) {
                break;
            }
        }

        // 가장 아래 점 찾기
        find = false;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (wallpaper[i].charAt(j) == '#') {
                    answer[2] = i + 1;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }

        return answer;
    }
}
