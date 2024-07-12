package Programmers;

import java.util.HashMap;
import java.util.Map;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/118666
* */
public class 성격유형검사하기 {
    public static void main(String[] args) {
        String[][] s = {{"AN", "CF", "MJ", "RT", "NA"}, {"TR", "RT", "TR"}};
        int[][] c = {{5, 3, 2, 7, 5}, {7, 1, 3}};

        for (int i = 0; i < 2; i++) {
            System.out.println(solution(s[i], c[i]));
        }
    }

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> valueMap = new HashMap<>();
        String[] category = {"RT", "CF", "JM", "AN"};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

        init(valueMap);

        for (int i = 0; i < choices.length; i++) {
            char firstChar = survey[i].charAt(0);
            char secondChar = survey[i].charAt(1);

            if (choices[i] < 4) {
                valueMap.put(firstChar, valueMap.get(firstChar) + score[choices[i]]);
            } else if (choices[i] > 4) {
                valueMap.put(secondChar, valueMap.get(secondChar) + score[choices[i]]);
            }
        }

        for (int i = 0; i < category.length; i++) {
            if (valueMap.get(category[i].charAt(0)) >= valueMap.get(category[i].charAt(1))) {
                answer.append(category[i].charAt(0));
            } else {
                answer.append(category[i].charAt(1));
            }
        }

        return answer.toString();
    }

    public static void init(Map<Character, Integer> valueMap) {
        valueMap.put('A', 0);
        valueMap.put('N', 0);
        valueMap.put('R', 0);
        valueMap.put('T', 0);
        valueMap.put('C', 0);
        valueMap.put('F', 0);
        valueMap.put('J', 0);
        valueMap.put('M', 0);
    }
}
