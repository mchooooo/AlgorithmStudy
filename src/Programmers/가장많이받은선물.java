package Programmers;

import java.util.HashMap;
import java.util.Map;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/258712
* */
public class 가장많이받은선물 {
    public static void main(String[] args) {
        String[][] friends = {{"muzi", "ryan", "frodo", "neo"}, {"joy", "brad", "alessandro", "conan", "david"}, {"a", "b", "c"}};
        String[][] gifts = {{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"},{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"},{"a b", "b a", "c a", "a c", "a c", "c a"}};

        for (int i = 0; i < 3; i++) {
            System.out.println(solution(friends[i], gifts[i]));
        }

    }

    public static int solution (String[] friends, String[] gifts) {
        int answer = 0;
        int[][] giftArr = new int[friends.length][friends.length];
        int[] giftScoreArr = new int[friends.length];
        int[] resultArr = new int[friends.length];
        Map<String, Integer> friendIdxMap = new HashMap<>();

        int idx = 0;
        for (String friend : friends) {
            friendIdxMap.put(friend, idx++);
        }

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int to = friendIdxMap.get(split[0]);
            int from = friendIdxMap.get(split[1]);
            giftArr[to][from]++;

            giftScoreArr[to]++;
            giftScoreArr[from]--;

        }

        for (int i = 0; i < giftArr.length; i++) {
            for (int j = i + 1; j < giftArr.length; j++) {
                int give = giftArr[i][j];
                int take = giftArr[j][i];

                if (give > take) {
                    resultArr[i]++;
                } else if (take > give) {
                    resultArr[j]++;
                } else {
                   if (giftScoreArr[i] > giftScoreArr[j]) {
                       resultArr[i]++;
                   } else if (giftScoreArr[j] > giftScoreArr[i]) {
                       resultArr[j]++;
                   }
                }
            }
        }

        for (int max : resultArr) {
            answer = Math.max(max, answer);
        }

        for (int[] ints : giftArr) {
            for (int j = 0; j < giftArr.length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }

        return answer;
    }
}
