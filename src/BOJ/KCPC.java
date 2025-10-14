package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/3758
 */
public class KCPC {
    static class Grade implements Comparable<Grade>{
        int id;
        int[] score;
        int sum;
        int count;
        int lastTime;
        Grade(int id, int numOfScore) {
            this.id = id;
            this.score = new int[numOfScore];
        }

        public int getSum() {
            return Arrays.stream(score).sum();
        }

        public void initSum() {
            sum = Arrays.stream(score).sum();
        }

        @Override
        public int compareTo(Grade g) {
            if (this.getSum() == g.getSum()) {
                if (this.count == g.count) {
                    return Integer.compare(this.lastTime, g.lastTime);
                }
                return Integer.compare(this.count, g.count);
            } else {
                return -Integer.compare(this.getSum(), g.getSum());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n, k, t, m = 0;
            String[] inp = br.readLine().split(" ");
            n = Integer.parseInt(inp[0]);
            k = Integer.parseInt(inp[1]);
            t = Integer.parseInt(inp[2]);
            m = Integer.parseInt(inp[3]);

            Grade[] team = new Grade[n];
            for (int i = 0; i < n; i++) {
                team[i] = new Grade(i, k);
            }

            for (int i = 0; i < m; i++) {
                inp = br.readLine().split(" ");
                int id, num, score = 0;
                id = Integer.parseInt(inp[0]) - 1;
                num = Integer.parseInt(inp[1]) - 1;
                score = Integer.parseInt(inp[2]);

                team[id].score[num] = Math.max(team[id].score[num], score);
                team[id].count++;
                team[id].lastTime = i;
            }

            Arrays.sort(team);

            for (int i = 0; i < team.length; i++) {
                if (team[i].id == t - 1) {
                    System.out.println(i+1);
                    break;
                }
            }




        }

    }
}
