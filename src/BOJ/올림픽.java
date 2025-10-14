package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
https://www.acmicpc.net/problem/8979
 */
public class 올림픽 {
    static class Rank {
        int idx;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Rank(int idx, int gold, int silver, int bronze) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean equals(Rank r) {
            return r.gold == this.gold && r.silver == this.silver && r.bronze == this.bronze;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sp = br.readLine().split(" ");
        int N = Integer.parseInt(sp[0]);
        int K = Integer.parseInt(sp[1]);

        Rank[] ranks = new Rank[N];

        for (int i = 0; i < N; i++) {
            sp = br.readLine().split(" ");
            ranks[i] = new Rank(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), Integer.parseInt(sp[2]), Integer.parseInt(sp[3]));
        }


        Arrays.sort(ranks, (o1, o2) -> {
            if (o1.gold == o2.gold) {
                if (o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                }
                return  o2.silver - o1.silver;
            }
            return o2.gold - o1.gold;
        });

        // 순위 매기기
        int rank = 2;
        ranks[0].rank = 1;
        for (int i = 1; i < N; i++) {
            if (ranks[i].equals(ranks[i-1])) {
                ranks[i].rank = ranks[i-1].rank;
                rank++;
                continue;
            }

            ranks[i].rank = rank++;
        }

        for (Rank r : ranks) {
            if (K == r.idx) {
                System.out.println(r.rank);
                break;
            }
        }


    }
}
