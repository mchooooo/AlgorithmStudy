package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9017
 */
public class 크로스컨트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int answer = 0;
            int length = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] team = new int[201];
            boolean[] race = new boolean[201];


            for (int j : arr) {
                team[j]++;
            }

            for (int i = 0; i < 201; i++) {
                if (team[i] >= 6) {
                    race[i] = true;
                }
            }

            int[][] scores = new int[201][6];
            int[] teamIdx = new int[201];
            int score = 1;
            for (int i = 0; i < length; i++) {
                if (race[arr[i]]) {
                    scores[arr[i]][teamIdx[arr[i]]++] = score++;
                }
            }

            //팀 점수 계산
            int bestScore = Integer.MAX_VALUE;
            int fifth = Integer.MAX_VALUE;

            for (int i = 0; i < 201; i++) {
                if (!race[i]) {
                    continue;
                }

                int sum = 0;
                for (int j = 0; j < 4; j++) {
                    sum += scores[i][j];
                }
                int five = scores[i][4];

                if (sum < bestScore || (sum == bestScore && five < fifth)) {
                    bestScore = sum;
                    fifth = five;
                    answer = i;
                }

            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }
}
