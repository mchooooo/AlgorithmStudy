package Programmers;

import java.util.HashMap;
import java.util.Map;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class 영어끝말잇기 {
    public static void main(String[] args) {
        int[] n = {3, 5, 2};
        String[][] w = {
            {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
            {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"},
            {"hello", "one", "even", "never", "now", "world", "draw"}
        };

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i], w[i]);
            for (int a : answer) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    private static int[] solution(int n, String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        int[] answer = new int[2];

        wordMap.put(words[0], 1);
        char lastCh = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {

            if (lastCh != words[i].charAt(0)) { // 끝말잇기를 안한 경우
//                answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                answer[0] = i % n + 1;
//                answer[1] = Math.max((i + 2) / n, 1);
                answer[1] = i / n + 1;
                return answer;
            }

            if (wordMap.containsKey(words[i])) { // 중복된 단어를 말한 경우
//                answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                answer[0] = i % n + 1;
//                answer[1] = Math.max((i + 2) / n, 1);
                answer[1] = i / n + 1;
                return answer;
            }

            wordMap.put(words[i], i + 1);
            lastCh = words[i].charAt(words[i].length() - 1);

        }


        return answer;

    }
}
