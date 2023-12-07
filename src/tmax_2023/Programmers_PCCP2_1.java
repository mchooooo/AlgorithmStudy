package tmax_2023;

/*
* https://school.programmers.co.kr/learn/courses/15009/lessons/121687?language=java
* [PCCP 모의고사 #2] 1번 - 실습용 로봇
* */
public class Programmers_PCCP2_1 {

    static int x;
    static int y;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        String[] command = {"GRGLGRG", "GRGRGRB"};
        for (int i = 0; i < command.length; i++) {
            int[] result = solution(command[i]);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(String command) {
        x = 0;
        y = 0;
        int[] answer = new int[2];
        int dir = 0;
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == 'R') {
                dir++;
                dir %= 4;
            }
            if (ch == 'L') {
                dir--;
                if (dir < 0) {
                    dir = 3;
                }
            }
            if (ch == 'G') {
                x += dx[dir];
                y += dy[dir];
            }

            if (ch == 'B') {
                int temp = (dir + 2) % 4;
                x += dx[temp];
                y += dy[temp];
            }
        }

        answer[0] = x;
        answer[1] = y;


        return answer;
    }
}
