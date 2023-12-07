package tmax_2023;

/*
* https://school.programmers.co.kr/learn/courses/15008/lessons/121684
* [PCCP 모의고사 #1] 2번 - 체육대회
* */
public class Programmers_PCCP1_2 {

    static int result = 0;
    static boolean[] visit;

    public static void main(String[] args) {
        int[][][] ability = {{{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}}, {{20, 30}, {30, 20}, {20, 30}}};
        for (int i = 0 ; i < ability.length; i++) {
            System.out.println(solution(ability[i]));
        }
    }

    public static int solution(int[][] ability) {
        visit = new boolean[11];
        result = 0;
        dfs(ability, 0, 0);
        return result;
    }

    public static void dfs(int[][] arr, int idx, int sum) {
        if (idx == arr[0].length){
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            // sum += arr[i][idx];
            dfs(arr, idx + 1, sum + arr[i][idx]);
            // sum -= arr[i][idx];
            visit[i] = false;
        }

    }

}
