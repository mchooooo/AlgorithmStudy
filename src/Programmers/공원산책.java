package Programmers;

public class 공원산책 {
    public static void main(String[] args) {
        String[][] p = {
            {"SOO","OOO","OOO"},
            {"OXO", "XSX", "OXO"},
            {"SOOXO", "OOOXO", "OXOOO", "XOOOO"},
            {"SOO","OOO","OOO"},
            {"SOO","OXX","OOO"},
            {"OSO","OOO","OXO","OOO"}
        };

        String[][] r = {
            {"N 3", "S 2"},
            {"S 1", "E 1", "W 1", "N 1"},
            {"E 2", "S 2", "W 2", "S 1", "W 1"},
            {"E 2","S 2","W 1"},
            {"E 2","S 2","W 1"},
            {"E 2","S 3","W 1"}
        };

        for (int i = 0; i < p.length; i++) {
            int[] result = solution(p[i], r[i]);
            for (int j : result) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int[][] arr = new int[park.length][park[0].length()];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }

                if (park[i].charAt(j) == 'X') {
                    arr[i][j] = 1;
                }
            }
        }

        for (String route : routes) {
            String[] temp = route.split(" ");
            move(arr, answer, temp[0], temp[1]);
        }

        return answer;
    }

    private static void move (int[][] arr, int[] answer , String dir, String distance) {
        int dist = Integer.parseInt(distance);
        int m;
        switch (dir) {
            case "E":
                m = answer[1] + dist;
                if (m < arr[0].length) {
                    for (int i = answer[1] + 1; i < m + 1; i++) {
                        if (arr[answer[0]][i] == 1) {
                            return;
                        }
                    }
                    answer[1] += dist;
                }

                break;
            case "W":
                m = answer[1] - dist; // 3 - 2 = 1
                if (m >= 0) {
                    for (int i = answer[1] - 1; i > m - 1; i--) {
                        if (arr[answer[0]][i] == 1) {
                            return;
                        }
                    }
                    answer[1] -= dist;
                }

                break;
            case "N":
                m = answer[0] - dist;
                if (m >= 0) {
                    for (int i = answer[0] - 1; i > m - 1; i--) {
                        if (arr[i][answer[1]] == 1) {
                            return;
                        }
                    }
                    answer[0] -= dist;
                }

                break;
            case "S":
                m = answer[0] + dist;
                if (m < arr.length) {
                    for (int i = answer[0] + 1; i < m + 1; i++) {
                        if (arr[i][answer[1]] == 1) {
                            return;
                        }
                    }
                    answer[0] += dist;
                }

                break;
        }
    }
}
