package Programmers;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/87946
* */
public class 피로도 {

    private static boolean[] chk;
    private static int answer;

    public static void main(String[] args) {
        int k = 80;
        int[][] d = {
            {80,20},{50,40},{30,10}
        };

        System.out.println(solution(k, d));
        
    }

    private static int solution(int k, int[][] dungeons) {
        answer = 0;
        chk = new boolean[dungeons.length];

        backtracking(k, dungeons, 0);

        return answer;
    }

    private static void backtracking(int k, int[][] dungeons, int cnt) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!chk[i]) {
                if (k >= dungeons[i][0]) {
                    chk[i] = true;
                    backtracking(k - dungeons[i][1], dungeons, cnt + 1);
                    chk[i] = false;
                }
            }
        }

        answer = Math.max(answer, cnt);
    }


}
